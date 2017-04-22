package edu.sjsu.cmpe275.lab2.controller;

import edu.sjsu.cmpe275.lab2.model.Flight;
import edu.sjsu.cmpe275.lab2.model.Passenger;

//import edu.sjsu.cmpe275.lab2.model.Passenger;

import edu.sjsu.cmpe275.lab2.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ssundar on 4/18/2017.
 */
@RequestMapping(value = "/ARS")
@RestController
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @RequestMapping(value = "/passenger",method = RequestMethod.POST,consumes = "application/json")
    public Passenger addPassenger(@RequestBody Passenger passenger){
        passengerService.addPassenger(passenger);
        return passenger;
    }

    @RequestMapping(value = "/Passengers",method = RequestMethod.GET,produces = "application/json;application/xml")
    public List<Passenger> getPassengers(){
        return passengerService.getAllPassengers();
    }
    //https://hostname/flight/flightNumber?price=120&&from=AA&to=BB&departureTime=CC&arrivalTime=DD
    //&description=EE&capacity=GG&model=HH&manufacturer=II&&yearOfManufacture=1997    
    
    @RequestMapping(value = "/flight/flightNumber",method = RequestMethod.POST,consumes = "application/json")
   public
   @ResponseBody
   Flight createFlight(@RequestParam("price") Float price,
		   @RequestParam("fromLocation") String fromLocation,
		   @RequestParam("toLocation") String toLocation,
		   @RequestParam("departureTime") String departureTime,
		   @RequestParam("arrivalTime") String arrivalTime,
		   @RequestParam("description") String description,
		   @RequestParam("capacity") String capacity,
		   @RequestParam("model") String model,
		   @RequestParam("manufacturer") String manufacturer,
		   @RequestParam("yearOfManufacture") String yearOfManufacture
		   )
   {
    	
    	
    	
	return passengerService.createFlight(price,fromLocation,toLocation,departureTime,arrivalTime,description,capacity,model,manufacturer,yearOfManufacture);
    	
   }
    

}
