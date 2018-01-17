package com.qa.apartment.business;

import org.junit.Assert;
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

	@InjectMocks
	PersonDBImple impl;

	@Mock
	private JSONUtil util;
	
	@Test
	public void testCreatePersonFromString() {
		impl.setUtil(util);
		
		String testJsonString = "{\"first_name\": \"James\",\"last_name\": \"Herbert\",\"email\": \"test@test.com\", \"phone_number\": \"01234567891\"}";
		Person aPerson = new Person("James", "Herbert", "test@test.com", "01234567891");
	
		Mockito.when(util.getObjectForJSON(testJsonString, Person.class)).thenReturn(aPerson);
		
		Assert.assertEquals(impl.findAllPersons().size(), 1);
		String returnedString = impl.createPersonFromString(testJsonString);
		Assert.assertEquals("{\"message\": \"person sucessfully added\"}", returnedString);
	
		Mockito.verify(util).getObjectForJSON(testJsonString, Person.class);
	
	
	}

}
