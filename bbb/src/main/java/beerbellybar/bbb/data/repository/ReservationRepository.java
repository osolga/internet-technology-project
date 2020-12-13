package beerbellybar.bbb.data.repository;

import beerbellybar.bbb.data.domain.BarTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import beerbellybar.bbb.data.domain.Reservation;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findByBarTableAndDate(BarTable barTable, Date reservationTime);
    List<Reservation> findByCustomerId(Long customerId);
    List<Reservation> findByIdAndCustomerId(Long reservationId, Long customerId);
    List<BarTable> findByIdNotInReservationAndReservationTime(Long barTableId, Date reservationTime);
}
