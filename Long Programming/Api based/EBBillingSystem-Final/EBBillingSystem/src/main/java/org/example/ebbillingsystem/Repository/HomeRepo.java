package org.example.ebbillingsystem.Repository;

import org.example.ebbillingsystem.Models.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepo extends JpaRepository<Home, Integer> {
}
