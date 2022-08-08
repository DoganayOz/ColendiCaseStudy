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

import com.payment.onlinePayment.dao.MerchantRepository;
import com.payment.onlinePayment.model.Merchant;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class MerchantServiceTest {
	
	@InjectMocks
	private static MerchantServiceImpl merchantService = new MerchantServiceImpl();
	
	@Mock
	MerchantRepository merchantRepository;
	
	@BeforeClass
	public static void setUp() throws Exception{
		MockitoAnnotations.initMocks(merchantService);
	}
	
	@Before
	public void initialize() throws NoSuchAlgorithmException {
		merchantService = new MerchantServiceImpl();
	}
	
	private Merchant fillBaseMerchant() {
		Merchant merchant = new Merchant();
		
		merchant.setGpaId(1);
		merchant.setMcc("Test");
		
		return merchant;
	}

	@Test
	public void addMerchant() throws Exception {
		merchantService.addMerchant(fillBaseMerchant());
	}
}