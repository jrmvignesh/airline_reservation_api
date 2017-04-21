package edu.sjsu.cmpe275.lab2.model;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Flight implements Serializable {

	@Id
	@ManyToOne(targetEntity = Reservation.class)
	@JoinColumn(name = "orderNumber")
	private String number; // Each flight has a unique flight number.
	private int price;
	private String fromDest;
	private String toDest;

	/*
	 * Date format: yy-mm-dd-hh, do not include minutes and sceonds. Example:
	 * 2017-03-22-19 The system only needs to supports PST. You can ignore other
	 * time zones.
	 */

	private Date departureTime;
	private Date arrivalTime;
	private int seatsLeft;
	private String description;
	@Embedded
	private Plane plane; // Embedded
	@OneToMany(mappedBy = "id")
	private List<Passenger> passengers;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
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

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
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

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

}
