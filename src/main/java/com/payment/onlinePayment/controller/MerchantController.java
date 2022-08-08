package com.payment.onlinePayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.payment.onlinePayment.model.Merchant;
import com.payment.onlinePayment.service.MerchantService;

@RestController
@RequestMapping("/Merchant")
public class MerchantController {
	
	@Autowired
	private MerchantService merchantService;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Merchant addMerchant(@RequestBody Merchant merchant) {
	    return merchantService.addMerchant(merchant);
	}
}
