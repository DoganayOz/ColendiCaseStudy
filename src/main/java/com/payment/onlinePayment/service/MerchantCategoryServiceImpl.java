package com.payment.onlinePayment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.onlinePayment.dao.MerchantCategoryRepository;
import com.payment.onlinePayment.model.MerchantCategory;

@Service
public class MerchantCategoryServiceImpl implements MerchantCategoryService {
	
	@Autowired
	MerchantCategoryRepository merchantCategoryRepository;

	@Override
	public MerchantCategory addMerchantCategory(MerchantCategory merchantCategory) {
		return merchantCategoryRepository.save(merchantCategory);
	}

	@Override
	public MerchantCategory findById(int mid) {
		return merchantCategoryRepository.findById(mid);
	}

}
