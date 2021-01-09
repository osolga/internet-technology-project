package beerbellybar.process.bbb.data.repository;

import beerbellybar.process.bbb.data.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByCustomerId(Long customerId);
    List<Reservation> findByIdAndCustomerId(Long reservationId, Long customerId);
    List<Reservation> findByReservationTimeAndCustomerId(Date reservationTime, Long customerId);
}
