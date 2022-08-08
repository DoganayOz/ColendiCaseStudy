package com.payment.onlinePayment.service;

import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.payment.onlinePayment.dao.PersonRepository;
import com.payment.onlinePayment.model.Person;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class PersonServiceTest {
	
	@InjectMocks
	private static PersonServiceImpl personService = new PersonServiceImpl();
	
	@Mock
	PersonRepository personRepository;
	
	@BeforeClass
	public static void setUp() throws Exception{
		MockitoAnnotations.initMocks(personService);
	}
	
	@Before
	public void initialize() throws NoSuchAlgorithmException {
		personService = new PersonServiceImpl();
	}
	
	private Person fillBasePerson() {
		Person person = new Person();
		
		person.setGpaId(1);
		person.setId(1);
		person.setName("test");
		person.setSurname("test");
		return person;
	}

	@Test
	public void addUser() throws Exception {
		personService.addUser(fillBasePerson());
	}

	@Test
	public void findById() throws Exception {
		personService.findById(1);
	}
}