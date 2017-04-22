package edu.sjsu.cmpe275.lab2.service;

import edu.sjsu.cmpe275.lab2.model.Flight;
import edu.sjsu.cmpe275.lab2.model.Passenger;
import edu.sjsu.cmpe275.lab2.repository.PassengerRepository;
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

    public void addPassenger(Passenger passenger){
        passengerRepository.save(passenger);
    }

    public List<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }

	public Flight createFlight(Float price, String fromLocation, String toLocation, String departureTime,
			String arrivalTime, String description, String capacity, String model, String manufacturer,
			String yearOfManufacture) {
		// TODO Auto-generated method stub
		return passengerRepository.createFlight(price,fromLocation,toLocation,departureTime,arrivalTime,description,capacity,model,manufacturer,yearOfManufacture);
	}


}
