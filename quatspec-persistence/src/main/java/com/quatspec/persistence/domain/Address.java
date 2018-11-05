package com.quatspec.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.quatspec.api.enums.AddressType;

@Embeddable
public class Address {
	
	@Column(name="property_id")
	private String propertyId;
	
	@Column(name="building_no")
	private String buildingNumber;
	
	@Column(name="street")
	private String street;
	
	@Column(name="lga")
	private String locality;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="postal_code")
	private String postalCode;
	
	@Column(name="country")
	private String country;
	
	@Enumerated(EnumType.STRING)
	private AddressType addressType;
	
	public Address() {}
	
	public Address(String propertyId, String buildingNumber, String street, String locality,
			String city, String state, String postalCode, String country) {
		this.propertyId = propertyId;
		this.buildingNumber = buildingNumber;
		this.street = street;
		this.locality = locality;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	
	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
}
