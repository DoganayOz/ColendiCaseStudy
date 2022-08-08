package com.payment.onlinePayment.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.payment.onlinePayment.bean.BaseOutputResponse;
import com.payment.onlinePayment.bean.PurchaseRequest;
import com.payment.onlinePayment.model.CardScope;
import com.payment.onlinePayment.model.CardTransaction;
import com.payment.onlinePayment.model.GeneralPurposeAccount;
import com.payment.onlinePayment.model.MerchantCategory;
import com.payment.onlinePayment.util.ExceptionCodes.EXCEPTION_CODE;
import com.payment.onlinePayment.util.OnlinePaymentException;
import com.payment.onlinePayment.util.TransactionType;

@Service
public class PurchaseServiceImpl extends BaseService implements PurchaseService {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(PurchaseServiceImpl.class);  
	
    @Autowired
	private CardTransactionService cardTransactionService;
    
	@Autowired
	CardScopeService cardScopeService;
	
	@Autowired
	MerchantCategoryService merchantCategoryServive;
	
	@Autowired
	GeneralPurposeAccountService generalPurposeAccountService;
	
	protected GeneralPurposeAccount gpa;

	@Override
	public BaseOutputResponse validateCardAndPayment(PurchaseRequest input) {
		BaseOutputResponse output = new BaseOutputResponse();
		boolean isCardAllowed = false;
		boolean isBalanceEnough = false;
		
		try {
			isCardAllowed = isCardAllowed(input.getCardId(), input.getMid());
			isBalanceEnough = isBalanceEnough(input.getCardId(), input.getAmount());
			
			if(isCardAllowed && isBalanceEnough) {
				payment(input);
			}else {
				throw new OnlinePaymentException(EXCEPTION_CODE.SYSTEM_ERROR.getCode(), "Validation error");
			}
		} catch (Exception e) {
			return exceptionResult(output, e, LOGGER);
		}
		return completeResponseResult(output, EXCEPTION_CODE.SUCCESS.getCode(), null);
	}
	
  public boolean isCardAllowed(int cardId, int mid) {
		
		boolean returnVal = false;
		
		List<CardScope> cardScope = new ArrayList<>();
		MerchantCategory merchantCategory = new MerchantCategory();
		
		merchantCategory = merchantCategoryServive.findById(mid);
		cardScope = cardScopeService.findByCardId(cardId);
		
		if((!cardScope.isEmpty() && cardScope != null) && merchantCategory != null) {
			for(CardScope cardScopeList : cardScope) {
				if(cardScopeList.getMid() == mid || merchantCategory.getMcc().equalsIgnoreCase(cardScopeList.getMcc())) {
					returnVal = true;
				}
			}
		}
		
		return returnVal;
	}
	
	public boolean isBalanceEnough(int cardId, double amount) {
		boolean returnVal = false;
		
		gpa = generalPurposeAccountService.findGpaByCardId(cardId);
		
		if(gpa != null && gpa.getBalanceAmount() >= amount) {
			returnVal = true;
		}
		
		return returnVal;
	}
	
	public BaseOutputResponse payment(PurchaseRequest input) throws OnlinePaymentException {
		GeneralPurposeAccount userGpa = new GeneralPurposeAccount();
		GeneralPurposeAccount merchantGpa = new GeneralPurposeAccount();
		CardTransaction cardTransaction = new CardTransaction();
		BaseOutputResponse output = new BaseOutputResponse();
		
		try {
			userGpa = gpa;
			if(userGpa != null) {
				userGpa.setBalanceAmount(userGpa.getBalanceAmount() - input.getAmount());
				
				userGpa = generalPurposeAccountService.saveOrUpdate(userGpa);
				
				merchantGpa = generalPurposeAccountService.findByOwnerId(input.getMid());
				merchantGpa.setBalanceAmount(merchantGpa.getBalanceAmount() + input.getAmount());
				
				merchantGpa = generalPurposeAccountService.saveOrUpdate(merchantGpa);
			}else {
				throw new OnlinePaymentException(EXCEPTION_CODE.SYSTEM_ERROR.getCode(), "User Gps not found");
			}
			
		} catch(NoSuchElementException e){
	        System.out.println(e.getMessage());
	        return exceptionResult(output, e, LOGGER);
	     }finally {
	    	cardTransaction.setAmount(input.getAmount());
	 		cardTransaction.setCardId(input.getCardId());
	 		cardTransaction.setMId(input.getMid());
	 		cardTransaction.setTransactionTypeId(TransactionType.CREDIT);
	 		cardTransaction.setTransactionTime(new Date());
	    	cardTransactionService.addCardTransaction(cardTransaction);
		}
		
		return completeResponseResult(output, EXCEPTION_CODE.SUCCESS.getCode(), null);
	}
}
