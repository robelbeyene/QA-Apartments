package com.qa.apartment.business;
//
import com.qa.apartment.persistance.Apartment;

public interface ApartmentService {
	public Apartment findApartment(long id);

	public String findAllApartments();

	public String createApartment(String apartment);

	public String deleteApartment(long id);

	public String updateApartment(long id, String newApartment);
}
