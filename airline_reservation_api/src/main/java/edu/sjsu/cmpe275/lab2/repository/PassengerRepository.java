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
public interface PassengerRepository extends JpaRepository<Passenger,String>{
    List<Passenger> findAll();

	Flight createFlight(Float price, String fromLocation, String toLocation, String departureTime, String arrivalTime,
			String description, String capacity, String model, String manufacturer, String yearOfManufacture);
}
