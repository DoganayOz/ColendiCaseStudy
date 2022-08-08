package com.payment.onlinePayment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.onlinePayment.model.GeneralPurposeAccount;

public interface GeneralPurposeAccountRepository extends JpaRepository<GeneralPurposeAccount, Integer>{
	GeneralPurposeAccount findById(int gpaId);

	GeneralPurposeAccount findByOwnerId(int ownerId);
}
