package com.qa.apartment.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.apartment.persistance.Person;
import com.qa.apartment.util.JSONUtil;

public class PersonMapImpl implements PersonService{

	private static final Logger LOGGER = Logger.getLogger(PersonMapImpl.class);
	private Map<Long, Person> personMap;
	
	@Inject
	private JSONUtil util;
	
	public PersonMapImpl() {
		this.personMap = new HashMap<Long, Person>();
		initPerson();
	}
	
	private void initPerson() {
		Person aPerson = new Person(1,"fName","lName", "email","phoneNumber");
		personMap.put((long)1, aPerson);
	}
	
	public String createPersonFromString(String person) {
		LOGGER.info("In createPersonFromString method about to add to create Person");
		Person aPerson = util.getObjectForJSON(person, Person.class);
		LOGGER.info("In createPersonFromString method about to add to map");
		personMap.put( aPerson.getPersonID(), aPerson);
		return "{\"message\": \"person sucessfully added\"}";
	}

	
	public String createPersonFromPerson(Person person) {
		personMap.put(person.getPersonID(), person);
		return "{\"message\": \"person sucessfully added\"}";
	}

	
	public String updatePersonFromString(Long id, String newDetails) {
		Person oldPerson = personMap.get(id);
		Person newPerson = util.getObjectForJSON(newDetails, Person.class);
		if(oldPerson != null) {
			oldPerson = newPerson;
			personMap.put(id, oldPerson);
			return "{\"message\": \"person sucessfully updated\"}";
		}
		else {
			return "{\"message\": \"person not updated see log\"}";
		}
	}

	
	public String updatePersonFromPerson(Long id, Person newDetails) {
		Person oldPerson = personMap.get(id);
		if(oldPerson != null) {
			oldPerson = newDetails;
			personMap.put(id, oldPerson);
			return "{\"message\": \"person sucessfully updated\"}";
		}
		else {
			return "{\"message\": \"person not updated see log\"}";
		}
	}

	public String deletePerson(Long id) {
		personMap.remove(id);
		return "{\"message\": \"person sucessfully deleted\"}";
	}

	
	public String findAllPersons() {
		return util.getJSONForObject(personMap);
	}
	
	public Person findPerson(Long id) {
		return personMap.get(id);
	}
}
