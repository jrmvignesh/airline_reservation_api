package edu.sjsu.cmpe275.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import edu.sjsu.cmpe275.lab2.model.Reservation;

public interface ReservationDBRepository extends CrudRepository<Reservation, Long> {
}