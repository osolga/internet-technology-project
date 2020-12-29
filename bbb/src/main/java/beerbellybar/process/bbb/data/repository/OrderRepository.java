package beerbellybar.process.bbb.data.repository;

import beerbellybar.process.bbb.data.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
