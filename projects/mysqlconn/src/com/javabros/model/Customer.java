package com.javabros.model;

public class Customer {
	private int id;
	private String fName;
	private String lName;
	private String city;
	private int zipcode;

	public Customer(String fName, String lName, String city, int zipcode) {
		this.fName = fName;
		this.lName = lName;
		this.city = city;
		this.zipcode = zipcode;
	}

	public Customer(int id, String fName, String lName, String city, int zipcode) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.city = city;
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return id + " " + fName + " " + lName + " " + city + " " + zipcode;
	}

	public int getId() {
		return id;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getCity() {
		return city;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
}
