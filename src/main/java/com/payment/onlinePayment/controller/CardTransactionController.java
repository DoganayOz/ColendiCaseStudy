package com.payment.onlinePayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.payment.onlinePayment.model.CardTransaction;
import com.payment.onlinePayment.service.CardTransactionService;

@RestController
@RequestMapping("/CardTransaction")
public class CardTransactionController {
	
	@Autowired
	private CardTransactionService cardTransactionService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CardTransaction addCardTransaction(@RequestBody CardTransaction cardTransaction) {
	    return cardTransactionService.addCardTransaction(cardTransaction);
	}
}
