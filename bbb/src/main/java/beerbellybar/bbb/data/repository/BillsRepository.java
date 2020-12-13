package beerbellybar.bbb.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import beerbellybar.bbb.data.domain.Bills;

@Repository
public interface BillsRepository extends JpaRepository<Bills, Long> {
    Bills findbyId(Long Id);
}
