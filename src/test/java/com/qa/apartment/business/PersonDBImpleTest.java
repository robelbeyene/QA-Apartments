package com.qa.apartment.business;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qa.apartment.persistance.Person;

public class PersonDBImpleTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void createPersonFromStringTest() {
		Person person1 = new Person(1, "Harry", "Potter", "harry.potter@qa.com", "01234567891");
		PersonDBImple em = new PersonDBImple();
		
		assertEquals("Result not expected", em.findAllPersons().size(), 1);
		
		em.createPersonFromPerson(person1);
		
		assertEquals("Result not expected", em.findAllPersons().size(), 2);
	}

}
