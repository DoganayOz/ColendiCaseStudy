package com.payment.onlinePayment.service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.payment.onlinePayment.bean.CardRequest;
import com.payment.onlinePayment.bean.PurchaseRequest;
import com.payment.onlinePayment.dao.CardRepository;
import com.payment.onlinePayment.model.Card;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class PurchaseServiceTest {
	
	@InjectMocks
	private static PurchaseServiceImpl purchaseService = new PurchaseServiceImpl();
	
	@Mock
    CardTransactionServiceImpl cardTransactionService;
    
	@Mock
	CardScopeServiceImpl cardScopeService;
	
	@Mock
	MerchantCategoryServiceImpl merchantCategoryServive;
	
	@Mock
	GeneralPurposeAccountServiceImpl generalPurposeAccountService;
	
	@BeforeClass
	public static void setUp() throws Exception{
		MockitoAnnotations.initMocks(purchaseService);
	}
	
	@Before
	public void initialize() throws NoSuchAlgorithmException {
		purchaseService = new PurchaseServiceImpl();
		cardTransactionService = new CardTransactionServiceImpl();
		cardScopeService = new CardScopeServiceImpl();
		merchantCategoryServive = new MerchantCategoryServiceImpl();
		generalPurposeAccountService = new GeneralPurposeAccountServiceImpl();
	}
	
	private PurchaseRequest fillPurchaseRequest() {
		PurchaseRequest purchaseRequest = new PurchaseRequest();
		
		purchaseRequest.setAmount(100.0);
		purchaseRequest.setCardId(1);
		purchaseRequest.setMid(1);
		return purchaseRequest;
	}

	@Test
	public void validateCardAndPayment() throws Exception {
		purchaseService.validateCardAndPayment(fillPurchaseRequest());
	}

	@Test
	public void isCardAllowed() throws Exception {
		purchaseService.isCardAllowed(1, 1);
	}
	
	@Test
	public void isBalanceEnough() throws Exception {
		purchaseService.isBalanceEnough(1, 100.0);
	}
	
	@Test
	public void payment() throws Exception {
		purchaseService.payment(fillPurchaseRequest());
	}
}