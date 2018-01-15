package com.qa.apartment.persistance;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Apartment {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column
	@NotNull
	private String buildingName;
	@Column
	@NotNull
	private String apartmentNo;
	@Column
	@NotNull
	private String agency;
	@Column
	private String landlord;
	@Column
	@NotNull
	private String tenant;
	@Column
	@NotNull
	private String leaseStart;
	@Column
	@NotNull
	private String leaseEnd;
	@Column
	@NotNull
	private String breakClause;
	@Column
	@NotNull
	private String agencyPhoneNo;
	@Column
	private int noRooms;
	@Column
	@NotNull
	private double rent;
	@Column
	private String notes;
	@Column
	@NotNull
	private String address;
	@Column
	@NotNull
	private double deposit;
	
	public Apartment(String buildingName, String apartmentNo, String agency, String landlord, String tenant,
			String leaseStart, String leaseEnd, String breakClause, String agencyPhoneNo, int noRooms, double rent,
			String notes, String address, double deposit) {
		super();
		this.buildingName = buildingName;
		this.apartmentNo = apartmentNo;
		this.agency = agency;
		this.landlord = landlord;
		this.tenant = tenant;
		this.leaseStart = leaseStart;
		this.leaseEnd = leaseEnd;
		this.breakClause = breakClause;
		this.agencyPhoneNo = agencyPhoneNo;
		this.noRooms = noRooms;
		this.rent = rent;
		this.notes = notes;
		this.address = address;
		this.deposit = deposit;
	}

	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getApartmentNo() {
		return apartmentNo;
	}
	public void setApartmentNo(String apartmentNo) {
		this.apartmentNo = apartmentNo;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getLandlord() {
		return landlord;
	}
	public void setLandlord(String landlord) {
		this.landlord = landlord;
	}
	public String getTenant() {
		return tenant;
	}
	public void setTenant(String tenant) {
		this.tenant = tenant;
	}
	public String getLeaseStart() {
		return leaseStart;
	}
	public void setLeaseStart(String leaseStart) {
		this.leaseStart = leaseStart;
	}
	public String getLeaseEnd() {
		return this.leaseEnd;
	}
	public void setLeaseEnd(String leaseEnd) {
		this.leaseEnd = leaseEnd;
	}
	public String getBreakClause() {
		return breakClause;
	}
	public void setBreakClause(String breakClause) {
		this.breakClause = breakClause;
	}
	public String getAgencyPhoneNo() {
		return agencyPhoneNo;
	}
	public void setAgencyPhoneNo(String agencyPhoneNo) {
		this.agencyPhoneNo = agencyPhoneNo;
	}
	public int getNoRooms() {
		return noRooms;
	}
	public void setNoRooms(int noRooms) {
		this.noRooms = noRooms;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}		

}
