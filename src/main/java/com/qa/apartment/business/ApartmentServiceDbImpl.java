package com.qa.apartment.business;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.qa.apartment.util.JSONUtil;

public class ApartmentServiceDbImpl {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	private JSONUtil jsonUtil = new JSONUtil();
	
	

}
