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
import com.payment.onlinePayment.dao.CardTransactionRepository;
import com.payment.onlinePayment.model.Card;
import com.payment.onlinePayment.model.CardTransaction;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CardTransactionServiceTest {
	
	@InjectMocks
	private static CardTransactionServiceImpl cardTransactionService = new CardTransactionServiceImpl();
	
	@Mock
	CardTransactionRepository cardTransactionRepository;
	
	@BeforeClass
	public static void setUp() throws Exception{
		MockitoAnnotations.initMocks(cardTransactionService);
	}
	
	@Before
	public void initialize() throws NoSuchAlgorithmException {
		cardTransactionService = new CardTransactionServiceImpl();
	}
	
	private CardTransaction fillBaseCardTransaction() {
		CardTransaction cardTransaction = new CardTransaction();
		
		cardTransaction.setAmount(100.0);
		cardTransaction.setCardId(1);
		cardTransaction.setMId(1);
		cardTransaction.setTransactionTypeId(1);
		cardTransaction.setTransactionTime(new Date());
		
		return cardTransaction;
	}

	@Test
	public void addCard() throws Exception {
		cardTransactionService.addCardTransaction(fillBaseCardTransaction());
	}
}