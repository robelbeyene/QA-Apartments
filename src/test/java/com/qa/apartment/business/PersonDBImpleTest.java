package com.qa.apartment.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.apartment.persistance.Person;
import com.qa.apartment.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class PersonDBImpleTest {

	private String testJsonStringA;
	private String testJsonStringB;
	private Person aPerson;
	private Person bPerson;
	
	@InjectMocks
	PersonMapImpl impl;

	@Mock
	private JSONUtil util;

	@Before
	public void setUp() {
		impl.setUtil(util);
		
		String testJsonStringA = "{\"first_name\": \"James\",\"last_name\": \"Herbert\",\"email\": \"test@test.com\", \"phone_number\": \"01234567891\"}";
		String testJsonStringB = "{\"first_name\": \"Jenkins\",\"last_name\": \"Harlot\",\"email\": \"test2@test.com\", \"phone_number\": \"01234567891\"}";
		
		Person aPerson = new Person("James", "Herbert", "test@test.com", "01234567891");
		Person bPerson = new Person("Jenkins", "Harlot", "test2@test.com", "01234567891");
	}

	@Test
	public void testCreatePersonFromString() {
		Mockito.when(util.getObjectForJSON(testJsonStringA, Person.class)).thenReturn(aPerson);

		String returnedString = impl.createPersonFromString(testJsonStringA);
		Assert.assertEquals("{\"message\": \"person sucessfully added\"}", returnedString);

		Mockito.verify(util).getObjectForJSON(testJsonStringA, Person.class);
	}

	@Test
	public void testCreatePersonFromPerson() {
		String returnedString = impl.createPersonFromPerson(aPerson);
		Assert.assertEquals("{\"message\": \"person sucessfully added\"}", returnedString);
	}
	
	@Test
	public void updatePersonFromString() {
		Mockito.when(util.getObjectForJSON(testJsonStringA, Person.class)).thenReturn(aPerson);
		Mockito.when(util.getObjectForJSON(testJsonStringB, Person.class)).thenReturn(bPerson);
		
		String returnedString = impl.createPersonFromString(testJsonStringA);
		Assert.assertEquals("{\"message\": \"person sucessfully added\"}", returnedString);

		returnedString = impl.updatePersonFromString(1L, testJsonStringB);
		Assert.assertEquals("{\"message\": \"person sucessfully updated\"}", returnedString);

		returnedString = impl.updatePersonFromString(1L, testJsonStringB);
		Assert.assertEquals("{\"message\": \"person not updated see log\"}", returnedString);

		
	}

}
