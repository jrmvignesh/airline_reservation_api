package edu.sjsu.cmpe275.lab2.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.sjsu.cmpe275.lab2.model.Flight;
import edu.sjsu.cmpe275.lab2.model.Passenger;
import edu.sjsu.cmpe275.lab2.model.Reservation;
import edu.sjsu.cmpe275.lab2.service.PassengerService;
import edu.sjsu.cmpe275.lab2.service.ReservationService;

@RestController
public class ReservationController {

	@Autowired
	ReservationService reservationService;

	@RequestMapping(value = "/reservation", method = RequestMethod.POST)
	public ResponseEntity<?> createReservation(@RequestParam("passengerId") Long id,
			@RequestParam("flightList") List<String> flightList) {
		System.out.println("In create reservation method!!!!");
		reservationService.createReservation(id, flightList);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/reservation/{reservationNumber}", method = RequestMethod.DELETE)
	public ResponseEntity<?> cancelReservation(@PathVariable("reservationNumber") Long reservationNumber) {
		System.out.println("In cancel reservation method!!!!");
		reservationService.cancelReservation(reservationNumber);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	

	@RequestMapping(value = "/reservations", method = RequestMethod.GET)
	public ResponseEntity<List<Reservation>> getReservation(
			@RequestParam(value="passengerId", required = false) Long id,
			@RequestParam(value="SourceLocation" , required = false) String fromLocation,
			@RequestParam(value="DestinationLocation" , required = false) String toLocation,
			@RequestParam(value="FlightId", required = false) String number			
			) {
		
		System.out.println("In get reservation method!!!!");
		List<Reservation> reservationList = reservationService.getReservation(id,fromLocation,toLocation,number);
		
		System.out.println("finally - end");
		for(Reservation reservation : reservationList)
			System.out.println(reservation.getReservationNumber());
		System.out.println("*******");
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity(reservationList,headers, HttpStatus.CREATED);
	}
	
	
}
