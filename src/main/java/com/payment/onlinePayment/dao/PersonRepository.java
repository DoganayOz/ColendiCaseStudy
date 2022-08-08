package com.payment.onlinePayment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.onlinePayment.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{
	Person findById(int userId);
}
