package com.payment.onlinePayment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payment.onlinePayment.bean.BaseOutputResponse;
import com.payment.onlinePayment.bean.PurchaseRequest;
import com.payment.onlinePayment.service.PurchaseService;

@RestController
@RequestMapping("/Payment")
public class PaymentController {
	
	@Autowired
	private PurchaseService purchaseService;

    @RequestMapping(method = RequestMethod.POST, path = "/purchase")
    public BaseOutputResponse purchase(@Valid @RequestBody PurchaseRequest input) {  
    	 return purchaseService.validateCardAndPayment(input);
    }
}
