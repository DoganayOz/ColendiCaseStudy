package com.payment.onlinePayment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.onlinePayment.model.CardTransaction;

public interface CardTransactionRepository extends JpaRepository<CardTransaction, Integer>{

}
