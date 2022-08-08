package com.payment.onlinePayment.service;

import java.util.List;

import com.payment.onlinePayment.bean.CardScopeRequest;
import com.payment.onlinePayment.model.CardScope;

public interface CardScopeService {
	CardScope addCardScope(CardScopeRequest input);

	List<CardScope> findByCardId(int cardId);
}
