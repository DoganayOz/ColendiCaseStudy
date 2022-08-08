package com.payment.onlinePayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.payment.onlinePayment.bean.DepositCardRequest;
import com.payment.onlinePayment.model.GeneralPurposeAccount;
import com.payment.onlinePayment.service.GeneralPurposeAccountService;

@RestController
@RequestMapping("/GeneralPurposeAccount")
public class GeneralPurposeAccountController {
	
	@Autowired
	private GeneralPurposeAccountService generalPurposeAccountService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public GeneralPurposeAccount addGeneralPurposeAccount(@RequestBody GeneralPurposeAccount generalPurposeAccount) {
	    return generalPurposeAccountService.addGeneralPurposeAccount(generalPurposeAccount);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/depositCard")
	public GeneralPurposeAccount depositCard(@Validated @RequestBody DepositCardRequest input) {
	    return generalPurposeAccountService.depositCard(input);
	}
}
