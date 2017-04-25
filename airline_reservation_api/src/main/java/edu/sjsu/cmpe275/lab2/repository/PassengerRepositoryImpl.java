package edu.sjsu.cmpe275.lab2.repository;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.sjsu.cmpe275.lab2.model.Flight;
import edu.sjsu.cmpe275.lab2.model.Passenger;
import edu.sjsu.cmpe275.lab2.model.Plane;

public class PassengerRepositoryImpl implements PassengerRepository{

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public List<Passenger> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInBatch(Iterable<Passenger> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Passenger> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Passenger> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Passenger> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Passenger> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Passenger getOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Passenger> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Passenger> S saveAndFlush(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Passenger> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Passenger> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Passenger findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Passenger entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Passenger> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Passenger> S findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Passenger> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Passenger> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Passenger> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Flight createFlight(Flight flight) {
		// TODO Auto-generated method stub

		return flightRepository.save(flight);
	}



	@Override
	public Passenger createFlight(Passenger passenger) {
		// TODO Auto-generated method stub
		return userRepository.save(passenger);
	}

}
