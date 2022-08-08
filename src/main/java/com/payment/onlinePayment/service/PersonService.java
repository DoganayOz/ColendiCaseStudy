package com.payment.onlinePayment.service;

import com.payment.onlinePayment.model.Person;

public interface PersonService {
	Person addUser(Person user);
	Person findById(int userId);
}
