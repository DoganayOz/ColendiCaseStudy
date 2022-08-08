package com.payment.onlinePayment.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.payment.onlinePayment.bean.CardRequest;
import com.payment.onlinePayment.bean.DepositCardRequest;
import com.payment.onlinePayment.model.Card;

public interface CardService {
	Card addCard(Card card);
	Card reIssueCard(CardRequest cardRequest);
	List<Card> getCardsByUserId(int userId);
	Integer cancelCard(int cardId);
	Card findById(int cardId);
}
