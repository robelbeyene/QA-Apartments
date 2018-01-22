package com.qa.apartment.integration;

import javax.ws.rs.*;
import org.apache.log4j.Logger;
import com.qa.apartment.business.ApartmentServiceDbImpl;
import com.qa.apartment.util.JSONUtil;

import javax.inject.*;
@Path("/apartment")
public class ApartmentEndpoint {
	private static final Logger LOGGER = Logger.getLogger(ApartmentEndpoint.class);
	
	@Inject
	JSONUtil jsonUtil; 
	
	@Inject
	ApartmentServiceDbImpl service;
	
	@Path("/json/{id}")
	@GET
	public String getApartment(@PathParam("id") long id) {
		return jsonUtil.getJSONForObject(service.findApartment(id));
	}
	
	@Path("/json")
	@GET
	public String getAllApartments() {
		return service.findAllApartments();
	}
	
	@Path("/json")
	@POST
	public String createApartment(String newAp) {
		LOGGER.info("in ApartmentEndpoint the value of string is  " + newAp );
		return service.createApartment(newAp);
	}
	
	@Path("/json/{id}")
	@DELETE
	public String deleteApartment(@PathParam("id") long id) {
		return service.deleteApartment(id);
	}
	
	@Path("/json/{id}")
	@PUT
	public String updateApartment(String newAp,@PathParam("id") long id) {
		return service.updateApartment(id, newAp);
	}
	
}
