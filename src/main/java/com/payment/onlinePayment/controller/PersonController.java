package com.payment.onlinePayment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.payment.onlinePayment.model.Person;
import com.payment.onlinePayment.service.PersonService;

@RestController
@RequestMapping("/User")
public class PersonController {
	
	@Autowired
	private PersonService userService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Person addUser(@Valid @RequestBody Person user) {
	    return userService.addUser(user);
	}
}
