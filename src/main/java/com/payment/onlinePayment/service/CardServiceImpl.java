package com.payment.onlinePayment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.payment.onlinePayment.bean.CardRequest;
import com.payment.onlinePayment.dao.CardRepository;
import com.payment.onlinePayment.model.Card;

@Service
public class CardServiceImpl implements CardService {
	
    @Autowired
	private CardRepository cardRepository;

	@Override
	public Card addCard(Card card) {
		return cardRepository.save(card);
	}

	@Override
	public List<Card> getCardsByUserId(int userId) {
		return cardRepository.findByUserId(userId);
	}
	
	@Override
	public Card reIssueCard(CardRequest cardRequest) {
		
		Card card = cardRepository.findById(cardRequest.getCardId());
		if(card != null) {
			card.setCvv(cardRequest.getCvv());
			card.setExpireDate(cardRequest.getExpireDate());
			card = cardRepository.save(card);
		}
		  
	  return card;
	}

	@Override
	public Integer cancelCard(int cardId) {
		Card card = cardRepository.findById(cardId);
		if(card != null) {
			card.setStatus("0");
			card = cardRepository.save(card);
		}
		
		return cardId;
	}

	@Override
	public Card findById(int cardId) {
		return cardRepository.findById(cardId);
	}
}
