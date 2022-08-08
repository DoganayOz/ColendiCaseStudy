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

import com.payment.onlinePayment.bean.DepositCardRequest;
import com.payment.onlinePayment.dao.CardTransactionRepository;
import com.payment.onlinePayment.dao.GeneralPurposeAccountRepository;
import com.payment.onlinePayment.model.GeneralPurposeAccount;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class GeneralPurposeAccountServiceTest {
	
	@InjectMocks
	private static GeneralPurposeAccountServiceImpl gpaService = new GeneralPurposeAccountServiceImpl();
	
	@Mock
	GeneralPurposeAccountRepository gpaRepository;
	
	@Mock
	CardServiceImpl cardService;
	
	@Mock
	PersonServiceImpl userService;
	
	@Mock
	CardTransactionServiceImpl cardTransactionService;
	
	@Mock
	CardTransactionRepository cardTransactionServiceRepository;
	
	@BeforeClass
	public static void setUp() throws Exception{
		MockitoAnnotations.initMocks(gpaService);
	}
	
	@Before
	public void initialize() throws NoSuchAlgorithmException {
		gpaService = new GeneralPurposeAccountServiceImpl();
		cardService = new CardServiceImpl();
		userService = new PersonServiceImpl();
		cardTransactionService = new CardTransactionServiceImpl();
	}
	
	private GeneralPurposeAccount fillBaseGpa() {
		GeneralPurposeAccount gpa = new GeneralPurposeAccount();
		
		gpa.setBalanceAmount(100.0);
		gpa.setOwnerId(1);
		gpa.setOwnerTypeId(1);
		
		return gpa;
	}
	
	private DepositCardRequest fillDepositCardRequest() {
		DepositCardRequest depositCardRequest = new DepositCardRequest();
		
		depositCardRequest.setAmount(100.0);
		depositCardRequest.setCardId(1);
		return depositCardRequest;
	}

	@Test
	public void addGpa() throws Exception {
		gpaService.addGeneralPurposeAccount(fillBaseGpa());
	}

	@Test
	public void depositCard() throws Exception {
		gpaService.depositCard(fillDepositCardRequest());
	}
	
	@Test
	public void findGpaByCardId() throws Exception {
		gpaService.findGpaByCardId(1);
	}
	
	@Test
	public void findByOwnerId() throws Exception {
		gpaService.findByOwnerId(1);
	}
	
	@Test
	public void saveOrUpdate() throws Exception {
		gpaService.saveOrUpdate(fillBaseGpa());
	}
}