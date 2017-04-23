package edu.sjsu.cmpe275.lab2.service;

import edu.sjsu.cmpe275.lab2.model.Flight;

import edu.sjsu.cmpe275.lab2.model.Passenger;
import edu.sjsu.cmpe275.lab2.repository.PassengerRepository;
import edu.sjsu.cmpe275.lab2.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;


/**
 * Created by ssundar on 4/18/2017.
 */
@Component
public class PassengerService {
    @Autowired
    PassengerRepository passengerRepository;
    
    @Autowired
    FlightRepository flightRepository;

    public void addPassenger(Passenger passenger){
        passengerRepository.save(passenger);
    }

    public List<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }

	public Flight createFlight(Flight flight) {
		// TODO Auto-generated method stub
		return flightRepository.createFlight(flight);
	}


}
