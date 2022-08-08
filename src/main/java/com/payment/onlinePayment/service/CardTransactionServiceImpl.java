package com.payment.onlinePayment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.onlinePayment.dao.CardTransactionRepository;
import com.payment.onlinePayment.model.CardTransaction;

@Service
public class CardTransactionServiceImpl implements CardTransactionService{

    @Autowired
	private CardTransactionRepository cardTransactionRepository;

	@Override
	public CardTransaction addCardTransaction(CardTransaction cardTransaction) {
		return cardTransactionRepository.save(cardTransaction);
	}
}
