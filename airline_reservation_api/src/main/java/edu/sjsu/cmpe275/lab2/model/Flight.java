package edu.sjsu.cmpe275.lab2.model;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Flight {

	@Id
	private String number; // Each flight has a unique flight number.
	private Float price;
	private String fromDest;
	private String toDest;

	/*
	 * Date format: yy-mm-dd-hh, do not include minutes and sceonds. Example:
	 * 2017-03-22-19 The system only needs to supports PST. You can ignore other
	 * time zones.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reservation_number")
	private Reservation reservation;
	private String departureTime;
	private String arrivalTime;
	private int seatsLeft;
	private String description;
	
	
	
	@OneToMany(mappedBy = "id")
	private List<Passenger> passengers;
	
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getFromDest() {
		return fromDest;
	}

	public void setFromDest(String fromDest) {
		this.fromDest = fromDest;
	}

	public String getToDest() {
		return toDest;
	}

	public void setToDest(String toDest) {
		this.toDest = toDest;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime2) {
		this.departureTime = departureTime2;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getSeatsLeft() {
		return seatsLeft;
	}

	public void setSeatsLeft(int seatsLeft) {
		this.seatsLeft = seatsLeft;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

}
