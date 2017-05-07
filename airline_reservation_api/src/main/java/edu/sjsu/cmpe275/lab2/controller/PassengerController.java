package edu.sjsu.cmpe275.lab2.controller;

import edu.sjsu.cmpe275.lab2.model.ErrorResponse;

import edu.sjsu.cmpe275.lab2.model.Flight;

import edu.sjsu.cmpe275.lab2.model.Passenger;

//import edu.sjsu.cmpe275.lab2.model.Passenger;

import edu.sjsu.cmpe275.lab2.service.PassengerService;

import org.hibernate.hql.internal.ast.ErrorReporter;
import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by vignesh on 4/18/2017.
 */

@RestController
public class PassengerController {

    @Autowired
    PassengerService passengerService;



    //https://hostname/passenger?firstname=XX&lastname=YY&age=11&gender=famale&phone=123
    @RequestMapping(value = "/passenger", method = RequestMethod.POST)
    public String createPassenger(
    		HttpServletRequest request,
   		 HttpServletResponse response,
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
    	
    	p.setFirstname(firstname);
    	p.setLastname(lastname);
    	p.setAge(age);
    	p.setGender(gender);
    	p.setPhone(phone);
    	
    	Passenger pResponse = passengerService.createPassenger(p);
    	
    	HttpHeaders headers = new HttpHeaders();
    	
		
    	ErrorResponse err = new ErrorResponse();
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        if(pResponse == null){
        response.setStatus(404);
        err.setCode(404+"");
        err.setMsg("another passenger with the same number already exists.");
        try {
        	jsonInString = mapper.writeValueAsString(err);
        } catch (JsonProcessingException e) {
        	e.printStackTrace(); 
        	}
        return jsonInString;
        }
        try {
        	jsonInString = mapper.writeValueAsString(pResponse);
        } catch (JsonProcessingException e) {
        	e.printStackTrace(); 
        	}
        System.out.println(jsonInString);     
        response.setStatus(200);
        return jsonInString;
    }
    
    @RequestMapping(method = RequestMethod.PUT , value = "/passenger/{id}" )
    public String updatePassenger(
    		 HttpServletRequest request,
    		 HttpServletResponse response,
    		@PathVariable Long id,
    		@RequestParam ("firstname") String firstname,
    		@RequestParam ("lastname") String lastname,
    		@RequestParam ("age") int age,
    		@RequestParam ("gender") String gender,
    		@RequestParam ("phone") String phone
    		) 
    
    
    {
    	System.out.println("In update passenger method!!!!");
    	System.out.println(firstname + " --> " + lastname);
    	Passenger p = new Passenger();
    	
    	p.setFirstname(firstname);
    	p.setLastname(lastname);
    	p.setAge(age);
    	p.setGender(gender);
    	p.setPhone(phone);
    	
    	Passenger updatedPassenger = passengerService.updatePassenger(id,p);
    	
    	ErrorResponse err = new ErrorResponse();
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        
        if(updatedPassenger == null){
        response.setStatus(404);
        err.setCode(404+"");
        err.setMsg("Sorry, the requested passenger with id " + id + " can not be updated");
        try {
        	jsonInString = mapper.writeValueAsString(err);
        } catch (JsonProcessingException e) {
        	e.printStackTrace(); 
        	}
        return jsonInString;
        }
        else{
        try {
        	jsonInString = mapper.writeValueAsString(updatedPassenger);
        } catch (JsonProcessingException e) {
        	e.printStackTrace(); 
        	}
        System.out.println(jsonInString);     
        response.setStatus(200);
        return jsonInString;
        }
    		

    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/passenger/{id}" )
    public String deletePassenger(
    		 HttpServletRequest request,
    		 HttpServletResponse response,
    		@PathVariable Long id)

    {
    	System.out.println("In DELETE passenger method!!!!");
    	
    	
    	 
    	Passenger p = passengerService.getPassenger(id);
    	ErrorResponse err = new ErrorResponse();
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        if(p == null){
        response.setStatus(404);
        err.setCode(404+"");
        err.setMsg("Sorry, the requested passenger with id " + id + " does not exist");
        try {
        	jsonInString = mapper.writeValueAsString(err);
        } catch (JsonProcessingException e) {
        	e.printStackTrace(); 
        	}
        return jsonInString;
        }
        
        passengerService.deletePassenger(id);
        
        response.setStatus(200);
        err.setCode(200+"");
        err.setMsg("The requested passenger with id " + id + " is deleted successfully");
    	
        try {
        	jsonInString = mapper.writeValueAsString(err);
        } catch (JsonProcessingException e) {
        	e.printStackTrace(); 
        	}
        return jsonInString;
        

    }
    
    @RequestMapping(value = "/passenger/{id}", method = RequestMethod.GET)
    public String getPassenger(
    		 HttpServletRequest request,
    		 HttpServletResponse response,
    		@PathVariable ("id") Long id
    		) 
    {
    	
    	System.out.println("In get paseenger method!!!!");
    	
    	    	Passenger p = passengerService.getPassenger(id);
    	
    	HttpHeaders headers = new HttpHeaders();
       
    	ErrorResponse err = new ErrorResponse();
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        if(p == null){
        response.setStatus(404);
        err.setCode(404+"");
        err.setMsg("Sorry, the requested passenger with id " + id + " does not exist");
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
    
    @RequestMapping(value = "/passenger/{id}", method = RequestMethod.GET,params = "xml=true", produces = { MediaType.APPLICATION_XML_VALUE })
    public String getPassengerAsXML(
    		 HttpServletRequest request,
    		 HttpServletResponse response,
    		@PathVariable ("id") Long id
    		) 
    {
    	
    	System.out.println("In get XML paseenger method!!!!");
    	
    	    	Passenger p = passengerService.getPassenger(id);
    	
    	HttpHeaders headers = new HttpHeaders();
       
    	ErrorResponse err = new ErrorResponse();
    	XmlMapper mapper = new XmlMapper();
        String jsonInString = "";
        if(p == null){
        response.setStatus(404);
        err.setCode(404+"");
        err.setMsg("Sorry, the requested passenger with id " + id + " does not exist");
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
    

}
