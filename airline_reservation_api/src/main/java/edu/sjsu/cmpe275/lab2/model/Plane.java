 	package edu.sjsu.cmpe275.lab2.model;

 	import javax.persistence.Access;
 	import javax.persistence.AccessType;
 	import javax.persistence.Column;
 	import javax.persistence.Embeddable;
 	import javax.persistence.Id;

@Embeddable @Access(AccessType.FIELD)
public class Plane {

	private int capacity;
	private String model;
	private String manufacturer;
	private int yearOfManufacture;

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}


	}
