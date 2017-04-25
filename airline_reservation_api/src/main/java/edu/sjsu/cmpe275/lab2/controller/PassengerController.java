package edu.sjsu.cmpe275.lab2.controller;

import edu.sjsu.cmpe275.lab2.model.Flight;
import edu.sjsu.cmpe275.lab2.model.Passenger;

//import edu.sjsu.cmpe275.lab2.model.Passenger;

import edu.sjsu.cmpe275.lab2.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by ssundar on 4/18/2017.
 */

@RestController
public class PassengerController {

    @Autowired
    PassengerService passengerService;


/*    @RequestMapping(value = "/passenger",method = RequestMethod.POST,consumes = "application/json")
    public Passenger addPassenger(@RequestBody Passenger passenger){
        passengerService.addPassenger(passenger);
        return passenger;
    }

    @RequestMapping(value = "/Passengers",method = RequestMethod.GET,produces = "application/json;application/xml")
    public List<Passenger> getPassengers(){
        return passengerService.getAllPassengers();
    }*/
    
    //https://hostname/flight/flightNumber?price=120&&from=AA&to=BB&departureTime=CC&arrivalTime=DD
    //&description=EE&capacity=GG&model=HH&manufacturer=II&&yearOfManufacture=1997    
    
    @RequestMapping(value = "/flights/flightNumber", method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity<?> createUser(@RequestBody Flight flight) {
    	System.out.println("In create flight method!!!!");	
    	passengerService.createFlight(flight);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    //https://hostname/passenger?firstname=XX&lastname=YY&age=11&gender=famale&phone=123


    @RequestMapping(value = "/passenger", method = RequestMethod.POST)
    public ResponseEntity<?> createPassenger(
    		@RequestParam ("id") String id,
    		@RequestParam ("firstname") String firstname,
    		@RequestParam ("lastname") String lastname,
    		@RequestParam ("age") int age,
    		@RequestParam ("gender") String gender,
    		@RequestParam ("phone") String phone
    		
    		) 
    
    {
    	System.out.println("In create paseenger method!!!!");
    	
    	System.out.println(firstname + " --> " + lastname);
    	
    	Passenger p = new Passenger();
    	p.setId(id);
    	p.setFirstname(firstname);
    	p.setLastname(lastname);
    	p.setAge(age);
    	p.setGender(gender);
    	p.setPhone(phone);
    	
    	passengerService.createPassenger(p);
    	
    	HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    		

    }
    

}
