package com.payment.onlinePayment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.onlinePayment.model.Card;

public interface CardRepository extends JpaRepository<Card, Integer>{
	Card findById(int cardId);
	List<Card> findByUserId(int userId);

}
