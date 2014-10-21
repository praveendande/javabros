package com.tutor.entity;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String city;
	private int zipcode;

	public Customer(int id, String firstName, String lastName, String city,
			int zipcode) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.zipcode = zipcode;
	}

	public Customer(String firstName, String lastName, String city, int zipcode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.zipcode = zipcode;
	}

	public String toString() {
		return this.id + " " + this.firstName + " " + this.lastName + " "
				+ this.city + "  " + this.zipcode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
