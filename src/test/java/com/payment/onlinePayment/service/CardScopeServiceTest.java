package com.payment.onlinePayment.service;

import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.payment.onlinePayment.bean.CardScopeRequest;
import com.payment.onlinePayment.dao.CardScopeRepository;
import com.payment.onlinePayment.dao.MerchantCategoryRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CardScopeServiceTest {
	
	@InjectMocks
	private static CardScopeServiceImpl cardScopeService = new CardScopeServiceImpl();
	
	@Mock
	CardScopeRepository cardScopeRepository;
	
	@Mock
	MerchantCategoryRepository merchantCategoryRepository;
	
	@BeforeClass
	public static void setUp() throws Exception{
		MockitoAnnotations.initMocks(cardScopeService);
	}
	
	@Before
	public void initialize() throws NoSuchAlgorithmException {
		cardScopeService = new CardScopeServiceImpl();
	}
	
	private CardScopeRequest fillCardScopeRequest() {
		CardScopeRequest cardScopeRequest = new CardScopeRequest();
		
		cardScopeRequest.setCardId(1);
		cardScopeRequest.setMcc("TEST");
		cardScopeRequest.setMid(1);
		return cardScopeRequest;
	}

	@Test
	public void addCardScope() throws Exception {
		cardScopeService.addCardScope(fillCardScopeRequest());
	}

	@Test
	public void findByCardId() throws Exception {
		cardScopeService.findByCardId(1);
	}
}