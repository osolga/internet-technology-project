package beerbellybar.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import beerbellybar.data.domain.Bills;

@Repository
public interface BillsRepository extends JpaRepository<Bills, Long> {
    Bills findbyId(Long Id);
}
