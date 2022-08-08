package com.payment.onlinePayment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.onlinePayment.model.CardScope;

public interface CardScopeRepository extends JpaRepository<CardScope, Integer>{

	List<CardScope> findByCardId(int cardId);

}
