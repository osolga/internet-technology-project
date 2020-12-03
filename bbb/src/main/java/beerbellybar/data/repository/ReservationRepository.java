package beerbellybar.data.repository;

import beerbellybar.data.domain.BarTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.integration.jpa.dsl.Jpa;
import org.springframework.stereotype.Repository;
import beerbellybar.data.domain.Reservation;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findByBarTableAndDate(BarTable barTable, String reservationTime);
    List<Reservation> findByCustomerId(Long customerId);
    List<Reservation> findByIdAndCustomerId(Long reservationId, Long customerId);
    List<BarTable> findByIdNotInReservationAndReservationTime(Long barTableId, String reservationtime);
}
