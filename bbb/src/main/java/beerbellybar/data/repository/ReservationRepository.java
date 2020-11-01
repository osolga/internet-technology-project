package beerbellybar.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.integration.jpa.dsl.Jpa;
import org.springframework.stereotype.Repository;
import beerbellybar.data.domain.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findbyId(Long Id);
}
