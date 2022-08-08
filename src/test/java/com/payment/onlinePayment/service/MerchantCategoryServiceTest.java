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

import com.payment.onlinePayment.dao.MerchantCategoryRepository;
import com.payment.onlinePayment.model.MerchantCategory;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class MerchantCategoryServiceTest {
	
	@InjectMocks
	private static MerchantCategoryServiceImpl merchantCategoryService = new MerchantCategoryServiceImpl();
	
	@Mock
	MerchantCategoryRepository merchantCategoryRepository;
	
	@BeforeClass
	public static void setUp() throws Exception{
		MockitoAnnotations.initMocks(merchantCategoryService);
	}
	
	@Before
	public void initialize() throws NoSuchAlgorithmException {
		merchantCategoryService = new MerchantCategoryServiceImpl();
	}
	
	private MerchantCategory fillBaseMerchantCategory() {
		MerchantCategory merchantCategory = new MerchantCategory();
		
		merchantCategory.setDescription("TEST");
		merchantCategory.setMcc("Test");
		
		return merchantCategory;
	}

	@Test
	public void addMerchantCategory() throws Exception {
		merchantCategoryService.addMerchantCategory(fillBaseMerchantCategory());
	}
	
	@Test
	public void findById() throws Exception {
		merchantCategoryService.findById(1);
	}
}