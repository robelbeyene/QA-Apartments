package com.qa.apartment.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.apartment.persistance.Person;

public class PersonDBImpleTest {
/*
	private String person1Str;
	private String person2Str;
	private PersonDBImple em;
	private Person person1;
	private Person person2;

	@Before
	public void setUp() {	
		person1Str = "{ \"id\":1, \"first_name\":\"Hary\", \"last_name\":\"Poter\", \"email\":\"hary.poter@qa.com\", \"phone_number\":\"01234568891\"";
		person2Str = "{ \"id\":1, \"first_name\":\"Harry\", \"last_name\":\"Potter\", \"email\":\"harry.potter@qa.com\", \"phone_number\":\"01234567891\"";
		em = new PersonDBImple();
		
		person1 = new Person(1, "Hary", "Poter", "hary.potte@qa.com", "01234567881");
		person2 = new Person(1, "Harry", "Potter", "harry.potter@qa.com", "01234567891");
	}

	@Test
	public void createPersonFromStringTest() {
		assertEquals("Result not expected at point before adding person1", em.findAllPersons().size(), 1);
		em.createPersonFromString(person1Str);
		assertEquals("Result not expected at point after adding person1", em.findAllPersons().size(), 2);
	}

	@Test
	public void createPersonFromPersonTest() {
		assertEquals("Result not expected at point before adding person1", em.findAllPersons().size(), 1);
		em.createPersonFromPerson(person1);
		assertEquals("Result not expected at point after adding person1", em.findAllPersons().size(), 2);
	}

	@Test
	public void updatePersonFromPersonTest() {
		em.createPersonFromPerson(person1);
		assertEquals("Result not expected at point before updating person1", em.findPerson(1L), person1);
		em.updatePersonFromPerson(person2);
		assertEquals("Result not expected at point after updating person1", em.findPerson(1L), person2);
	}

	@Test
	public void updatePersonFromStringTest() {
		em.createPersonFromPerson(person1);
		assertEquals("Result not expected at point before updating person1", em.findPerson(1L), person1);
		em.updatePersonFromString(null, person2Str);
		assertEquals("Result not expected at point after updating person1", em.findPerson(1L), person2);
	}

	@Test
	public void deletePersonTest() {
		em.createPersonFromPerson(person1);
		em.createPersonFromPerson(person2);

		assertEquals("Result not expected at point before adding person1", em.findAllPersons().size(), 2);
		em.deletePerson(2);
		assertEquals("Result not expected at point before adding person1", em.findAllPersons().size(), 1);
	}

	@Test
	public void findAllPersonsTest() {
		em.createPersonFromPerson(person1);
		em.createPersonFromPerson(person2);

		List<Person> resultList = em.findAllPersons();

		assertEquals("Result not expected", resultList.get(0).getPersonID(), 1);
		assertEquals("Result not expected", resultList.get(1).getPersonID(), 2);

	}

	@Test
	public void findPersonTest() {
		em.createPersonFromPerson(person1);
		em.createPersonFromPerson(person2);

		assertEquals("Result not expected", em.findPerson(1L), person1);
		assertEquals("Result not expected", em.findPerson(2L), person1);
	}*/

}
