package edu.sjsu.cmpe275.lab2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.ManyToAny;

@Entity
public class Reservation {
	
	@Id
	private String orderNumber;
	
	@ManyToOne(cascade = CascadeType.ALL,optional = false, targetEntity=Passenger.class)
	@JoinColumn(name="Pass_Id")
	private Passenger passenger;
	
	private int price;
	
	@OneToMany(mappedBy="number")
	private List<Flight> flights;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

}
