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
import org.springframework.boot.test.context.SpringBootTest;

import com.payment.onlinePayment.bean.CardRequest;
import com.payment.onlinePayment.dao.CardRepository;
import com.payment.onlinePayment.model.Card;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CardServiceTest {
	
	@InjectMocks
	private static CardServiceImpl cardService = new CardServiceImpl();
	
	@Mock
	CardRepository cardRepository;
	
	@Mock
	Card card;
	
	@BeforeClass
	public static void setUp() throws Exception{
		MockitoAnnotations.initMocks(cardService);
	}
	
	@Before
	public void initialize() throws NoSuchAlgorithmException {
		cardService = new CardServiceImpl();
		card = new Card();
	}
	
	private Card fillBaseCard() {
		Card card = new Card();
		
		card.setCardNo("1234");
		card.setCvv(001);
		card.setExpireDate(new Date());
		card.setStatus("1");
		card.setUserId(1);
		
		return card;
	}
	
	private CardRequest fillCardRequest() {
		CardRequest cardRequest = new CardRequest();
		
		cardRequest.setCardId(1);
		cardRequest.setCvv(001);
		cardRequest.setExpireDate(new Date());
		return cardRequest;
	}

	@Test
	public void addCard() throws Exception {
		cardService.addCard(fillBaseCard());
	}

	@Test
	public void getCardsByUserId() throws Exception {
		cardService.getCardsByUserId(1);
	}
	
	@Test
	public void reIssueCard() throws Exception {
		cardService.reIssueCard(fillCardRequest());
	}
	
	@Test
	public void cancelCard() throws Exception {
		cardService.cancelCard(1);
	}
	
	@Test
	public void findById() throws Exception {
		cardService.findById(1);
	}
}