package edu.sjsu.cmpe275.lab2.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.sjsu.cmpe275.lab2.model.Flight;

public class FlightRepositoryImpl implements FlightRepository 
{
	@Autowired
	private  UserRepository repository;

    
	@Override
	@Transactional
	public Flight createFlight(Flight flight) {
		// TODO Auto-generated method stub
		System.out.println("Testing "+ flight.getDepartureTime()+flight.getDescription());
		return repository.save(flight);

	}
	
}