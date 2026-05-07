package org.example.electricitybillingsystem.Services;

import org.example.electricitybillingsystem.Repository.ElectricityCenterRepo;
import org.example.electricitybillingsystem.Models.ElectricityCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcServices {
    @Autowired
    ElectricityCenterRepo ecr;
    @Autowired
    ElectricityCenter electricityCenter;


    public ResponseEntity<HttpStatus> createElectricityCenter(ElectricityCenter electricityCenter) {
        ElectricityCenter electricityCenter1=ecr.save(electricityCenter);
        if(electricityCenter1!=null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<List<ElectricityCenter>> getElectricityCenters() {
        List<ElectricityCenter> electricityCenters=ecr.findAll();
        if(electricityCenters.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(electricityCenters,HttpStatus.OK);
    }

    public ResponseEntity<ElectricityCenter> getElectricityCenter(int id) {
        ElectricityCenter electricityCenter= ecr.findById(id).orElse(null);
        if(electricityCenter!=null){
            return new ResponseEntity<>(electricityCenter,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
