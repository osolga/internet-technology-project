package beerbellybar.bbb.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import beerbellybar.bbb.data.domain.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findbyId(Long Id);
}
