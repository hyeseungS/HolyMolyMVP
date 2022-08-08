package com.amazingavocado.holymolymvp.repository;

import com.amazingavocado.holymolymvp.model.Reservation;
import com.amazingavocado.holymolymvp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}