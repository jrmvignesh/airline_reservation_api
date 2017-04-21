package edu.sjsu.cmpe275.lab2.controller;

import edu.sjsu.cmpe275.lab2.model.Passenger;

//import edu.sjsu.cmpe275.lab2.model.Passenger;

import edu.sjsu.cmpe275.lab2.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

}
