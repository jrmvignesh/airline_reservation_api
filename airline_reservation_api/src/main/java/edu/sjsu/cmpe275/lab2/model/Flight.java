package edu.sjsu.cmpe275.lab2.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="Flight")
@XmlRootElement
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "number", scope = Flight.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Flight implements Serializable {
	

	@Id
	@Column(name = "FlightId",unique=true, nullable = false)
	private String number; // Each flight has a unique flight number.
	
	@Column(name="Price",nullable = false)  
	private Float price;
	
	@Column(name="SourceLocation",nullable = false)
	private String fromLocation;
	
	@Column(name="DestinationLocation",nullable = false)
	private String toLocation;

	@ManyToMany(mappedBy = "flights")
	private List<Reservation> reservation;
	
	/*
	 * Date format: yy-mm-dd-hh, do not include minutes and sceonds. Example:
	 * 2017-03-22-19 The system only needs to supports PST. You can ignore other
	 * time zones.
	 */
	@JsonFormat(pattern = "yy-MM-dd-HH", timezone = "UTC")
	@Column(name="DepartureTime", nullable = false)
	private LocalDateTime departureTime;
	
	@JsonFormat(pattern = "yy-MM-dd-HH", timezone = "UTC")
	@Column(name="ArrivalTime",nullable = false)
	private LocalDateTime arrivalTime;
	
	@Column(name="SeatsLeft",nullable = false)
	private int seatsLeft;
	
	@Column(name="Description",nullable = false)
	private String description;
	
	@Embedded
	private Plane plane;

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

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
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



}
