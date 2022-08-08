package com.payment.onlinePayment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.onlinePayment.model.MerchantCategory;

public interface MerchantCategoryRepository extends JpaRepository<MerchantCategory, Integer>{
	MerchantCategory findById(int mId);
}
