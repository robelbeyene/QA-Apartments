package com.qa.apartment.business;

import java.util.List;

import com.qa.apartment.persistance.Apartment;

public interface ApartmentService {
	public Apartment findApartment(long id);

	public List<Apartment> findAllApartments();

	public String createApartment(Apartment apartment);

	public String deleteApartment(long id);

	public String updateApartment(long id, Apartment newApartment);
}
