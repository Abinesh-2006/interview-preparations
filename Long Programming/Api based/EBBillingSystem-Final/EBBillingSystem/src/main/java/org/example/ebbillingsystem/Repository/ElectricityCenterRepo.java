package org.example.ebbillingsystem.Repository;

import org.example.ebbillingsystem.Models.ElectricityCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricityCenterRepo extends JpaRepository<ElectricityCenter, Integer> {
}
