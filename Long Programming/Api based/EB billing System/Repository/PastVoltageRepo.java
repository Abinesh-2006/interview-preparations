package org.example.electricitybillingsystem.Repository;

import org.example.electricitybillingsystem.Models.PastVoltages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PastVoltageRepo extends JpaRepository<PastVoltages,Integer> {
    @Query("Select voltage from PastVoltages voltage where voltage.home.homeNo=:homeNo")
    List<PastVoltages> findByHomeNo(@Param("homeNo") int homeNo);
}
