package beerbellybar.process.bbb.data.repository;

import beerbellybar.process.bbb.data.domain.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface menuItemRepository extends JpaRepository<MenuItem, Long> {
}
