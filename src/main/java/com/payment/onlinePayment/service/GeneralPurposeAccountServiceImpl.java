package com.payment.onlinePayment.service;

import java.util.Date;
import java.util.NoSuchElementException;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.onlinePayment.bean.DepositCardRequest;
import com.payment.onlinePayment.dao.CardRepository;
import com.payment.onlinePayment.dao.GeneralPurposeAccountRepository;
import com.payment.onlinePayment.dao.PersonRepository;
import com.payment.onlinePayment.model.Card;
import com.payment.onlinePayment.model.CardTransaction;
import com.payment.onlinePayment.model.GeneralPurposeAccount;
import com.payment.onlinePayment.model.Person;
import com.payment.onlinePayment.util.OwnerType;
import com.payment.onlinePayment.util.TransactionType;

@Service
public class GeneralPurposeAccountServiceImpl implements GeneralPurposeAccountService {
	
	@Autowired
	GeneralPurposeAccountRepository generalPurposeAccountRepository;
	
	@Autowired
	CardService cardService;
	
	@Autowired
	PersonService userService;
	
	@Autowired
	CardTransactionService cardTransactionService;
	
	@Override
	public GeneralPurposeAccount addGeneralPurposeAccount(GeneralPurposeAccount generalPurposeAccount) {
		return generalPurposeAccountRepository.save(generalPurposeAccount);
	}

	@Override
	public GeneralPurposeAccount depositCard(DepositCardRequest input) {
		GeneralPurposeAccount generalPurposeAccount = new GeneralPurposeAccount();
		Card card = new Card();
		Person user = new Person();
		CardTransaction cardTransaction = new CardTransaction();
		
		double userBalance = 0;
		
		try {
			card = cardService.findById(input.getCardId());
			if(card != null) {
				user = userService.findById(card.getUserId());
				generalPurposeAccount = generalPurposeAccountRepository.findById(user.getGpaId());
				
				if(generalPurposeAccount != null) {
					userBalance = generalPurposeAccount.getBalanceAmount() + input.getAmount();
				}else {
					userBalance = input.getAmount();
				}
				
				generalPurposeAccount.setBalanceAmount(userBalance);
				generalPurposeAccount.setId(user.getGpaId());
				generalPurposeAccount.setOwnerId(user.getId());
				generalPurposeAccount.setOwnerTypeId(OwnerType.USER);
			}
		} catch(NoSuchElementException ex){
	        System.out.println(ex.getMessage());
	     }finally {
	    	 cardTransaction.setAmount(userBalance);
	    	 cardTransaction.setCardId(input.getCardId());
	    	 cardTransaction.setMId(0);
	    	 cardTransaction.setTransactionTime(new Date());
	    	 cardTransaction.setTransactionTypeId(TransactionType.DEPOSIT);
	    	 cardTransactionService.addCardTransaction(cardTransaction);
		}
		return generalPurposeAccountRepository.save(generalPurposeAccount);
	}

	@Override
	public GeneralPurposeAccount findGpaByCardId(int cardId) {
		Card card = new Card();
		GeneralPurposeAccount gpa = new GeneralPurposeAccount();
		card = cardService.findById(cardId);
		if(card != null) {
			return generalPurposeAccountRepository.findByOwnerId(card.getUserId());
		}else {
			return gpa;
					
		}
	}

	@Override
	public GeneralPurposeAccount findByOwnerId(int mid) {
		return generalPurposeAccountRepository.findByOwnerId(mid);
	}

	@Override
	public GeneralPurposeAccount saveOrUpdate(GeneralPurposeAccount gpa) {
		return generalPurposeAccountRepository.save(gpa);
	}

}
