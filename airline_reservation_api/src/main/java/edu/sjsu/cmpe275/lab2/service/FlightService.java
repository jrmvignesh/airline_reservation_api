package edu.sjsu.cmpe275.lab2.service;

import edu.sjsu.cmpe275.lab2.model.Flight;
import edu.sjsu.cmpe275.lab2.model.Passenger;
import edu.sjsu.cmpe275.lab2.repository.FlightDBRepository;
import edu.sjsu.cmpe275.lab2.repository.PassengerDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;


/**
 * Created by vignesh on 4/18/2017.
 */

@Component
public class FlightService {

	@Autowired
	FlightDBRepository flightDBRepository;
    

	public Flight createFlight(Flight flight) {
		// TODO Auto-generated method stub
		return flightDBRepository.save(flight);
	}
	
	public Flight updateFlight(String flightNumber , Flight flight) {
		// TODO Auto-generated method stub
		
		Flight f = flightDBRepository.findOne(flightNumber);
		
		f.setArrivalTime(flight.getArrivalTime());
    	f.setDepartureTime(flight.getDepartureTime());
    	f.setDescription(flight.getDescription());
    	f.setFromLocation(flight.getFromLocation());
    	f.setToLocation(flight.getToLocation());
    	f.setPrice(flight.getPrice());
    	f.setSeatsLeft(flight.getSeatsLeft());
    	f.setPlane(flight.getPlane());
		
		return flightDBRepository.save(f);
	}

	public void deleteFlight(String flightNumber) {
		// TODO Auto-generated method stub
		flightDBRepository.delete(flightNumber);
	}

	public Flight getFlight(String flightNumber) {
		// TODO Auto-generated method stub
		return flightDBRepository.findOne(flightNumber);
	}


}
