package beerbellybar.process.bbb.data.repository;

import beerbellybar.process.bbb.data.domain.BarTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarTableRepository extends JpaRepository<BarTable, Long> {
    List<BarTable> findBarTablesByIdIsNotInAndReservationNotContaining();
}
