package beerbellybar.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import beerbellybar.data.domain.BarTable;

import java.util.List;

@Repository
public interface TableRepository extends JpaRepository<BarTable, Long> {
    BarTable findbyId(Long Id);
    List<BarTable> findAllByIdNotInAndReservation
}
