package beerbellybar.process.bbb.data.repository;

import beerbellybar.process.bbb.data.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
