package beerbellybar.data.repository;

import beerbellybar.data.domain.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface menuItemRepository extends JpaRepository<MenuItem, Long> {
}
