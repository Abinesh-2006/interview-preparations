package org.example.ebbillingsystem.Services;

import org.example.ebbillingsystem.Models.ElectricityCenter;
import org.example.ebbillingsystem.Repository.ElectricityCenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcServices {

    @Autowired
    ElectricityCenterRepo ecr;

    public ResponseEntity<HttpStatus> createElectricityCenter(ElectricityCenter ec) {
        try {
            ecr.save(ec);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<ElectricityCenter>> getElectricityCenters() {
        List<ElectricityCenter> list = ecr.findAll();
        if (list.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public ResponseEntity<ElectricityCenter> getElectricityCenter(int id) {
        return ecr.findById(id)
                .map(ec -> new ResponseEntity<>(ec, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
