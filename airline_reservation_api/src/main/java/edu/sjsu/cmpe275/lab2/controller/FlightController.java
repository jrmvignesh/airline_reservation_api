package edu.sjsu.cmpe275.lab2.controller;

import edu.sjsu.cmpe275.lab2.model.ErrorResponse;
import edu.sjsu.cmpe275.lab2.model.Flight;
	

import edu.sjsu.cmpe275.lab2.model.Passenger;
import edu.sjsu.cmpe275.lab2.model.Plane;
import edu.sjsu.cmpe275.lab2.service.FlightService;

//import edu.sjsu.cmpe275.lab2.model.Passenger;

import edu.sjsu.cmpe275.lab2.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by vignesh on 4/18/2017.
 */

@RestController
public class FlightController {

    @Autowired
    FlightService flightService;


    //https://hostname/flight/flightNumber?price=120&&from=AA&to=BB&departureTime=CC&arrivalTime=DD
    //&description=EE&capacity=GG&model=HH&manufacturer=II&&yearOfManufacture=1997    
    
    @RequestMapping(value = "/flight/{flightNumber}", method = RequestMethod.POST)
    public String createFlight(
    		HttpServletRequest request,
      		 HttpServletResponse response,
    		@PathVariable String flightNumber,
    		
    		@RequestParam ("arrivalTime") @DateTimeFormat(pattern = "yy-MM-dd-HH") LocalDateTime arrivalTime,
    		@RequestParam ("departureTime") @DateTimeFormat(pattern = "yy-MM-dd-HH") LocalDateTime  departureTime,
    		@RequestParam ("description") String description,
    		@RequestParam ("sourceLocation") String sourceLocation,
    		@RequestParam ("destinationLocation") String destinationLocation,  		
    		@RequestParam ("price") Float price,
    		@RequestParam ("capacity") int capacity,
    		@RequestParam ("model") String model,
    		@RequestParam ("manufacturer") String manufacturer,
    		@RequestParam ("yearOfManufacture") int yearOfManufacture,
    		@RequestParam ("seatsLeft") int seatsLeft
    		)    
    {

    	System.out.println("In create flight method!!!!");	
    	Flight f = new  Flight();
    	f.setNumber(flightNumber);
    	f.setArrivalTime(arrivalTime);
    	f.setDepartureTime(departureTime);
    	f.setDescription(description);
    	f.setFromLocation(sourceLocation);
    	f.setToLocation(destinationLocation);
    	f.setPrice(price);
    	f.setSeatsLeft(seatsLeft);
    	
    	
    	Plane p = new Plane();
    	
    	//Created a plane object of request parameter values
    	p.setCapacity(capacity);
    	p.setManufacturer(manufacturer);
    	p.setModel(model);
    	p.setYearOfManufacture(yearOfManufacture);
    	
    	f.setPlane(p);
    	
    	Flight flight = flightService.createFlight(f);
 
    	ErrorResponse err = new ErrorResponse();
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        if(flight == null){
        response.setStatus(404);
        err.setCode(404+"");
        err.setMsg("Sorry, the requested flight with id " + flightNumber + " does not exist");
        try {
        	jsonInString = mapper.writeValueAsString(err);
        } catch (JsonProcessingException e) {
        	e.printStackTrace(); 
        	}
        return jsonInString;
        }
        try {
        	jsonInString = mapper.writeValueAsString(p);
        } catch (JsonProcessingException e) {
        	e.printStackTrace(); 
        	}
        System.out.println(jsonInString);     
        response.setStatus(200);
        return jsonInString;
    }
    
    @RequestMapping(method = RequestMethod.PUT , value = "/flight/{flightNumber}")
    public String updateFlight(
    		HttpServletRequest request,
     		 HttpServletResponse response,
    		@PathVariable String flightNumber,
    		@RequestParam ("arrivalTime") LocalDateTime arrivalTime,
    		@RequestParam ("departureTime") LocalDateTime departureTime,
    		@RequestParam ("description") String description,
    		@RequestParam ("sourceLocation") String sourceLocation,
    		@RequestParam ("destinationLocation") String destinationLocation,  		
    		@RequestParam ("price") Float price,
    		@RequestParam ("capacity") int capacity,
    		@RequestParam ("model") String model,
    		@RequestParam ("manufacturer") String manufacturer,
    		@RequestParam ("yearOfManufacture") int yearOfManufacture,
    		@RequestParam ("seatsLeft") int seatsLeft
    
    		) 
    
    {
    	
    	
    	System.out.println("In update flight method!!!!");	
    	
    	Flight f = new  Flight(); 
    	
    	f.setArrivalTime(arrivalTime);
    	f.setDepartureTime(departureTime);
    	f.setDescription(description);
    	f.setFromLocation(sourceLocation);
    	f.setToLocation(destinationLocation);
    	f.setPrice(price);
    	f.setSeatsLeft(seatsLeft);
    	
    	
    	Plane p = new Plane();
    	
    	//Created a plane object of request parameter values
    	p.setCapacity(capacity);
    	p.setManufacturer(manufacturer);
    	p.setModel(model);
    	p.setYearOfManufacture(yearOfManufacture);
    	
    	f.setPlane(p);
    	
    	Flight flight = flightService.updateFlight(flightNumber,f);
    	
    	ErrorResponse err = new ErrorResponse();
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        if(flight == null){
        response.setStatus(404);
        err.setCode(404+"");
        err.setMsg("Sorry, the requested flight with id " + flightNumber + " does not exist");
        try {
        	jsonInString = mapper.writeValueAsString(err);
        } catch (JsonProcessingException e) {
        	e.printStackTrace(); 
        	}
        return jsonInString;
        }
        try {
        	jsonInString = mapper.writeValueAsString(p);
        } catch (JsonProcessingException e) {
        	e.printStackTrace(); 
        	}
        System.out.println(jsonInString);     
        response.setStatus(200);
        return jsonInString;
    	
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/airline/{flightNumber}" )
    public ResponseEntity<?> deletePassenger(@PathVariable String flightNumber)
    
    {
    	System.out.println("In DELETE passenger method!!!!");
    	      	
    	flightService.deleteFlight(flightNumber);
    	
    	HttpHeaders headers = new HttpHeaders();
    	
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    		

    }
    
    
    @RequestMapping(value = "/flight/{flightNumber}", method = RequestMethod.GET)
    public String getFlight(
    		 HttpServletRequest request,
    		 HttpServletResponse response,
    		@PathVariable ("flightNumber") String flightNumber
    		) 
    {
    	
    	System.out.println("In get flight XML method!!!!");
    	
    	    	Flight flight = flightService.getFlight(flightNumber);
    	System.out.println(flight.getDescription());
    	HttpHeaders headers = new HttpHeaders();
       
    	ErrorResponse err = new ErrorResponse();
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        if(flight == null){
        response.setStatus(404);
        err.setCode(404+"");
        err.setMsg("Sorry, the requested passenger with id " + flightNumber + " does not exist");
        try {
        	jsonInString = mapper.writeValueAsString(err);
        } catch (JsonProcessingException e) {
        	e.printStackTrace(); 
        	}
        return jsonInString;
        }
        try {
        	jsonInString = mapper.writeValueAsString(flight);
        } catch (JsonProcessingException e) {
        	e.printStackTrace(); 
        	}
        System.out.println(jsonInString);     
        response.setStatus(200);
        return jsonInString;
    }
    
    @RequestMapping(value = "/flight/{flightNumber}", method = RequestMethod.GET,params = "xml=true", produces = { MediaType.APPLICATION_XML_VALUE })
    public String getFlightAsXML(
    		 HttpServletRequest request,
    		 HttpServletResponse response,
    		@PathVariable ("flightNumber") String flightNumber
    		) 
    {
    	
    	System.out.println("In get flight XML method!!!!");
    	
    	    	Flight flight = flightService.getFlight(flightNumber);
    	
    	HttpHeaders headers = new HttpHeaders();
       
    	ErrorResponse err = new ErrorResponse();
        XmlMapper mapper = new XmlMapper();
        String jsonInString = "";
        if(flight == null){
        response.setStatus(404);
        err.setCode(404+"");
        err.setMsg("Sorry, the requested passenger with id " + flightNumber + " does not exist");
        try {
        	jsonInString = mapper.writeValueAsString(err);
        } catch (JsonProcessingException e) {
        	e.printStackTrace(); 
        	}
        return jsonInString;
        }
        try {
        	jsonInString = mapper.writeValueAsString(flight);
        } catch (JsonProcessingException e) {
        	e.printStackTrace(); 
        	}
        System.out.println(jsonInString);     
        response.setStatus(200);
        return jsonInString;
    }
   

}
