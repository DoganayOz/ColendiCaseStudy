package com.payment.onlinePayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.payment.onlinePayment.model.MerchantCategory;
import com.payment.onlinePayment.service.MerchantCategoryService;

@RestController
@RequestMapping("/MerchantCategory")
public class MerchantCategoryController {
	
	@Autowired
	private MerchantCategoryService merchantCategoryService;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MerchantCategory addMerchantCategory(@RequestBody MerchantCategory merchantCategory) {
	    return merchantCategoryService.addMerchantCategory(merchantCategory);
	}
}
