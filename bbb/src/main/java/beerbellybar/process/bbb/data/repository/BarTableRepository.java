package beerbellybar.process.bbb.data.repository;

import beerbellybar.process.bbb.data.domain.BarTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarTableRepository extends JpaRepository<BarTable, Long> {
}
