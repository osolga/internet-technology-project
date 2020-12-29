package beerbellybar.process.bbb.data.repository;

import beerbellybar.process.bbb.data.domain.Bills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillsRepository extends JpaRepository<Bills, Long> {
    Bills findbyId(Long Id);
}
