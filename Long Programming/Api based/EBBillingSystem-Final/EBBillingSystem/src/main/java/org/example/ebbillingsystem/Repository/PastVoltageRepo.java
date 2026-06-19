package org.example.ebbillingsystem.Repository;

import org.example.ebbillingsystem.Models.PastVoltages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PastVoltageRepo extends JpaRepository<PastVoltages, Integer> {

    // BUG FIX: original alias 'voltage' clashed with entity field 'voltage'
    // causing JPQL resolution failure. Renamed alias to 'pv'.
    @Query("SELECT pv FROM PastVoltages pv WHERE pv.home.homeNo = :homeNo ORDER BY pv.voltageMonth ASC")
    List<PastVoltages> findByHomeNo(@Param("homeNo") int homeNo);
}
