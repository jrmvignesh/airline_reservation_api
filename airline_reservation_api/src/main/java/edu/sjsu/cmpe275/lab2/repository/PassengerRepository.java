package edu.sjsu.cmpe275.lab2.repository;

import edu.sjsu.cmpe275.lab2.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ssundar on 4/18/2017.
 */

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,String>{
    List<Passenger> findAll();
}
