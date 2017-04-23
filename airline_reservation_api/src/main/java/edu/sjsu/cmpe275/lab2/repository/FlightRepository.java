package edu.sjsu.cmpe275.lab2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.sjsu.cmpe275.lab2.model.Flight;
import edu.sjsu.cmpe275.lab2.model.Passenger;

import java.util.List;

/**
 * Created by ssundar on 4/18/2017.
 */

@Repository
public interface FlightRepository{
    
	Flight createFlight(Flight flight);
}