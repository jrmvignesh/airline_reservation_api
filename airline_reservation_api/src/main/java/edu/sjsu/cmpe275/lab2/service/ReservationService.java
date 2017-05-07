package edu.sjsu.cmpe275.lab2.service;

import edu.sjsu.cmpe275.lab2.model.Flight;
import edu.sjsu.cmpe275.lab2.model.Passenger;
import edu.sjsu.cmpe275.lab2.model.Reservation;
import edu.sjsu.cmpe275.lab2.repository.FlightDBRepository;
import edu.sjsu.cmpe275.lab2.repository.PassengerDBRepository;
import edu.sjsu.cmpe275.lab2.repository.ReservationDBRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by vignesh on 4/18/2017.
 */
@Component
public class ReservationService {

	@Autowired
	ReservationDBRepository reservationDBRepository;

	@Autowired
	FlightDBRepository flightDBRepository;

	@Autowired
	PassengerDBRepository passengerDBRepository;

	String errorMsg = "";
	String successMsg = "";
	boolean isValidReservation = false;

	public Reservation createReservation(Long id, List<String> flightList) {
		// TODO Auto-generated method stub

		Reservation r = new Reservation();
		int totPrice = 0;
		List<Flight> flights = new ArrayList<Flight>();

		if (isSeatAvailable(flightList) && checkTimeOverlap(flightList)) {
			for (int i = 0; i < flightList.size(); i++) {
				String f = flightList.get(i);
				Flight flight = flightDBRepository.findOne(f);
				flights.add(flight);
				totPrice += flight.getPrice();
			}
		} else
			return null;

		System.out.println("success validation!!!!");
		r.setPrice(totPrice);
		r.setPassenger(passengerDBRepository.findOne(id));
		updateFlightSeats(flights, -1);
		r.setFlights(flights);
		return reservationDBRepository.save(r);
	}

	public void cancelReservation(Long reservationNumber) {
		// TODO Auto-generated method stub
		Reservation r = reservationDBRepository.findOne(reservationNumber);
		if (r != null) {
			List<Flight> flightList = r.getFlights();
			updateFlightSeats(flightList, 1);
			successMsg = "Reservation with number" + reservationNumber + " is cancelled successfully";
			reservationDBRepository.delete(r);
		} else
			errorMsg = "Reservation with number" + reservationNumber + " does not exists";
	}

	public List<Reservation> getReservation(Long id, String fromLocation, String toLocation, String number) {
		// TODO Auto-generated method stub
		System.out.println("In service method");
		
		Passenger p = null;
		Flight f = null;
		//System.out.println(id);
		if(id!=null)
		{
			p = passengerDBRepository.findOne(id);
		   if (p!=null)System.out.println("Passenger found " + p.getFirstname());
		}
		
		if(number!=null)
			f = flightDBRepository.findOne(number);
		
		List<Reservation> reservationList = null;
		
		System.out.println("Checking for passenger parameter");
		
		if (p != null) {
			reservationList = p.getReservations();
		}

		System.out.println("Checking for flight parameter");
		
		if (f != null) {
			if (p == null) {
				reservationList = f.getReservation();
			} else {
				for (Reservation reservation : reservationList) {
					List<Flight> flightList = reservation.getFlights();
					for (int i = 0; i < flightList.size(); i++) {
						if (flightList.get(i).getNumber() != number) {
							if (i == flightList.size() - 1)
								reservationList.remove(reservation);
							continue;
						} else
							break;
					}
				}
			}
		}
	

		System.out.println("Checking for location parameter");

		if (reservationList == null && (fromLocation != null || toLocation != null)) {
			System.out.println("Entering for location check!!!!!!");
			Set<Reservation> reservationSet = new HashSet<Reservation>();
			if (fromLocation != null && toLocation != null) {
				System.out.println("1ST PART");
				List<Flight> flightList = (List<Flight>) flightDBRepository.findAll();
				for (Flight flight : flightList) {
					System.out.println(flight.getFromLocation() + "--- ITERATING FLIGHT LOCATIONS ---"+ flight.getToLocation());
					if (flight.getFromLocation().equals(fromLocation) && flight.getToLocation().equals(toLocation)) {
						reservationSet.addAll(flight.getReservation());
						continue;
					}
				}
			} else if (fromLocation == null && toLocation != null) {
				System.out.println("2ND PART");
				List<Flight> flightList = (List<Flight>) flightDBRepository.findAll();
				for (Flight flight : flightList) {
					if (flight.getToLocation().equals(toLocation)) {
						reservationSet.addAll(flight.getReservation());
						continue;
					}
				}

			} else if (fromLocation != null && toLocation == null) {
				System.out.println("3RD PART");
				List<Flight> flightList = (List<Flight>) flightDBRepository.findAll();
				for (Flight flight : flightList) {
					if (flight.getFromLocation().equals(fromLocation)) {
						reservationSet.addAll(flight.getReservation());
						continue;
					}
				}
			} else {
			}
			
			reservationList = new ArrayList<Reservation>(reservationSet);
		}

		
		if (reservationList != null)
			return reservationList;
		return null;
	}

	private void updateFlightSeats(List<Flight> flightList, int seats) {
		// TODO Auto-generated method stub
		for (int i = 0; i < flightList.size(); i++) {
			flightList.get(i).setSeatsLeft(flightList.get(i).getSeatsLeft() + seats);
			flightDBRepository.save(flightList.get(i));
		}
	}

	private boolean checkTimeOverlap(List<String> flightList) {
		for (int i = 1; i < flightList.size(); i++) {
			String f1 = flightList.get(i);
			String f0 = flightList.get(i - 1);
			Flight flight0 = flightDBRepository.findOne(f0);
			Flight flight1 = flightDBRepository.findOne(f1);
			LocalDateTime date1 = flight0.getArrivalTime();
			LocalDateTime date2 = flight1.getDepartureTime();
			System.out.println(date1 + " --> " + date2);
			if (date2.compareTo(date1) == 1) {
				System.out.println(date2 + " --> " + date1);
				System.out.println(date2.compareTo(date1));
				continue;
			} else {
				errorMsg = "Time Overlap between " + flight0.getNumber() + " and " + flight1.getNumber();
				return false;
			}
		}
		return true;
	}

	private boolean isSeatAvailable(List<String> flightList) {
		for (int i = 0; i < flightList.size(); i++) {
			String f = flightList.get(i);
			Flight flight = flightDBRepository.findOne(f);
			if (flight.getSeatsLeft() >= 1 && flight.getSeatsLeft() <= flight.getPlane().getCapacity())
				continue;
			else {
				errorMsg = "Seats not available for the passenger";
				return false;
			}
		}
		return true;
	}

}
