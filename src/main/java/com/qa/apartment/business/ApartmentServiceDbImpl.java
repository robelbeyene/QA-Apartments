package com.qa.apartment.business;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.apartment.persistance.Apartment;
import com.qa.apartment.util.JSONUtil;

@Transactional(Transactional.TxType.SUPPORTS)
public class ApartmentServiceDbImpl implements ApartmentService {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
//	private JSONUtil jsonUtil = new JSONUtil();
	
	public Apartment findApartment(long id) {
		return em.find(Apartment.class,id);
	}
	
	public List<Apartment> findAllApartments() {
		TypedQuery<Apartment> query = em.createQuery("SELECT a FROM Apartment a ORDER BY a.id", Apartment.class);
		return query.getResultList();
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public String createApartment(Apartment apartment) {
		em.persist(apartment);
		return "added apartment";
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public String deleteApartment(long id) {
		em.remove(id);
		return "Back you go, back into hell";
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public String updateApartment(long id, Apartment newApartment) {
		newApartment = em.merge(findApartment(id));
		return "movie sucessfully updated";
	}
	
	

}
