package com.payment.onlinePayment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.onlinePayment.dao.MerchantRepository;
import com.payment.onlinePayment.model.Merchant;

@Service
public class MerchantServiceImpl implements MerchantService {
	
	@Autowired
	MerchantRepository merchantRepository;

	@Override
	public Merchant addMerchant(Merchant merchant) {
		return merchantRepository.save(merchant);
	}
}
