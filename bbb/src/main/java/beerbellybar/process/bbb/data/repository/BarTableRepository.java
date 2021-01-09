package beerbellybar.process.bbb.data.repository;

import beerbellybar.process.bbb.data.domain.BarTable;
import beerbellybar.process.bbb.data.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface BarTableRepository extends JpaRepository<BarTable, Long> {
    List<BarTable> findByReservationReservationTime(Date reservationTime);
    List<BarTable> findByReservationReservationTimeNot(Date reservationTime);
}
