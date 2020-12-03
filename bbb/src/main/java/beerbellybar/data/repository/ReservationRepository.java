package beerbellybar.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.integration.jpa.dsl.Jpa;
import org.springframework.stereotype.Repository;
import beerbellybar.data.domain.Reservation;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findByTableAndDate(Table table, String reservationTime);
    List<Reservation> findByCustomerId(Long customerId);
    List<Reservation> finByIdAndCustomerId(Long reservationId, Long customerId);
}
