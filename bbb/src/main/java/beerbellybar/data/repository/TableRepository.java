package beerbellybar.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import beerbellybar.data.domain.Table;

@Repository
public interface TableRepository extends JpaRepository<Table, Long> {
    Table findbyId(Long Id);
}
