package edu.sjsu.cmpe275.lab2.service;

import edu.sjsu.cmpe275.lab2.model.Flight;
import edu.sjsu.cmpe275.lab2.model.Passenger;
import edu.sjsu.cmpe275.lab2.repository.PassengerDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;


/**
 * Created by vignesh on 4/18/2017.
 */
@Component
public class PassengerService {

	@Autowired
    PassengerDBRepository passengerDBRepository;
    

	public Passenger createPassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		return passengerDBRepository.save(passenger);
	}


	public Passenger updatePassenger(Long id, Passenger passenger) {
		// TODO Auto-generated method stub
		
		Passenger p = passengerDBRepository.findOne(id);
		
		p.setId(id);
		p.setFirstname(passenger.getFirstname());
		p.setLastname(passenger.getLastname());
		p.setAge(passenger.getAge());
		p.setGender(passenger.getGender());
		p.setPhone(passenger.getPhone());
		
				
		return passengerDBRepository.save(p);
		
	}


	public void deletePassenger(Long id) {
		// TODO Auto-generated method stub
		passengerDBRepository.delete(id);
	
	
	}


	public Passenger getPassenger(Long id) {
		// TODO Auto-generated method stub
		
		Passenger p = passengerDBRepository.findOne(id);
		
		return p;
	}


}
