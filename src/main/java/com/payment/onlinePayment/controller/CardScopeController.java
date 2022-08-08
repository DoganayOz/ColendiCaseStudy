package com.payment.onlinePayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payment.onlinePayment.bean.CardScopeRequest;
import com.payment.onlinePayment.model.CardScope;
import com.payment.onlinePayment.service.CardScopeService;

@RestController
@RequestMapping("/CardScope")
public class CardScopeController {
	
	@Autowired
	private CardScopeService cardScopeService;
	
	
    @RequestMapping(method = RequestMethod.POST, path = "/addCardScope")
	public CardScope addCardScope(@Validated @RequestBody CardScopeRequest input) {
	    return cardScopeService.addCardScope(input);
	}
}
