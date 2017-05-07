package edu.sjsu.cmpe275.lab2.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="Reservation")
@XmlRootElement
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "reservationNumber", scope = Reservation.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reservation implements Serializable {
	
	  @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name="ReservationId")
	private Long reservationNumber;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Passenger_Id")
	private Passenger passenger;
	
	@Column(name="Price",nullable = false)
	private int price;
	
	@ManyToMany
	@JoinTable
	(
			name="Reservation_Flights",
			joinColumns={@JoinColumn(name="Reservation_Id",referencedColumnName="ReservationId")},
			inverseJoinColumns={@JoinColumn(name="Flight_Id",referencedColumnName="FlightId",unique=true)}
	)
	private List<Flight> flights;

	public Long getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(Long reservationNumber) {
		this.reservationNumber = reservationNumber;
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
