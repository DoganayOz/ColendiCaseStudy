package com.payment.onlinePayment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.onlinePayment.dao.PersonRepository;
import com.payment.onlinePayment.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonRepository userRepository;

	@Override
	public Person addUser(Person user) {
		return userRepository.save(user);
	}

	@Override
	public Person findById(int userId) {
		return userRepository.findById(userId);
	}
}
