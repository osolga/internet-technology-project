package beerbellybar.bbb.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import beerbellybar.bbb.data.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
    Customer findByEmailAndIdNot(String email, Long CustomerId);
}
