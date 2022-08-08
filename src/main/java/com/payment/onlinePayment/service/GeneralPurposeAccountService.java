package com.payment.onlinePayment.service;

import com.payment.onlinePayment.bean.DepositCardRequest;
import com.payment.onlinePayment.model.GeneralPurposeAccount;

public interface GeneralPurposeAccountService {
	GeneralPurposeAccount addGeneralPurposeAccount(GeneralPurposeAccount generalPurposeAccount);
	GeneralPurposeAccount depositCard(DepositCardRequest input);
	GeneralPurposeAccount findGpaByCardId(int cardId);
	GeneralPurposeAccount findByOwnerId(int mid);
	GeneralPurposeAccount saveOrUpdate(GeneralPurposeAccount userGpa);
}
