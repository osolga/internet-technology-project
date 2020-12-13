package beerbellybar.bbb.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import beerbellybar.bbb.data.domain.BarTable;
import beerbellybar.bbb.data.domain.Reservation;

import java.util.Date;
import java.util.List;

@Repository
public interface BarTableRepository extends JpaRepository<BarTable, Long> {
}
