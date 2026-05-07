package org.example.electricitybillingsystem.Repository;

import org.example.electricitybillingsystem.Models.ElectricityCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricityCenterRepo extends JpaRepository<ElectricityCenter,Integer> {

}
