package com.payment.onlinePayment.service;

import com.payment.onlinePayment.model.MerchantCategory;

public interface MerchantCategoryService {
	MerchantCategory addMerchantCategory(MerchantCategory merchantCategory);

	MerchantCategory findById(int mid);
}
