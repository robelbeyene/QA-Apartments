package com.qa.apartment.business;

import com.qa.apartment.persistance.Person;
import com.qa.apartment.util.JSONUtil;

public interface PersonService {

	public String createPersonFromString(String person);
	
	public String createPersonFromPerson(Person person);
	
	public String updatePersonFromString(Long id, String newDetails);
	
	public String updatePersonFromPerson(Long id, Person newDetails);
	
	public String deletePerson(Long id);
	
	public String findAllPersons();
	
	public Person findPerson(Long id);
	
	public JSONUtil getUtil();
	
	public void setUtil(JSONUtil util);
	
}
