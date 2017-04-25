package edu.sjsu.cmpe275.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sjsu.cmpe275.lab2.model.Passenger;


public interface UserRepository extends JpaRepository<Passenger, String> {
}
