package com.qa.apartment.business;

import java.util.List;

import com.qa.apartment.persistance.Person;

public interface PersonService {

	public String createPersonFromString(String person);
	
	public String createPersonFromPerson(Person person);
	
	public String updatePersonFromString(Long id, String newDetails);
	
	public String updatePersonFromPerson(Long id, Person newDetails);
	
	public String deletePerson(Long id);
	
	public String findAllPersons();
	
	public Person findPerson(Long id);
	
}
