package com.qa.apartment.business;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import com.qa.apartment.persistance.Person;
import com.qa.apartment.util.JSONUtil;

@Transactional(Transactional.TxType.SUPPORTS)
public class PersonDBImple {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	private JSONUtil util = new JSONUtil();

	@Transactional(Transactional.TxType.REQUIRED)
	public String createPersonFromString(String person) {
		Person aPerson = util.getObjectForJSON(person, Person.class);
		em.persist(aPerson);
		return "{\"message\": \"person sucessfully added\"}";
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public String createPersonFromPerson(Person person) {
		em.persist(person);
		return "{\"message\": \"person sucessfully added\"}";
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public String updatePersonFromString(String newDetails) {
		Person aPerson = util.getObjectForJSON(newDetails, Person.class);
		em.merge(aPerson);
		return "{\"message\": \"person sucessfully updated\"}";
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public String updatePersonFromPerson(Person newDetails) {
		em.merge(newDetails);
		return "{\"message\": \"person sucessfully updated\"}";
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public String deletePerson(long id) {
		em.remove(findPerson(id));
		return "{\"message\": \"person sucessfully removed\"}";
	}

	public List<Person> findAllPersons() {
		TypedQuery<Person> query = em.createQuery("SELECT p FROM PERSON p ORDER BY p.id", Person.class);

		return query.getResultList();
	}

	public Person findPerson(Long id) {
		return em.find(Person.class, id);
	}

}
