package org.example.electricitybillingsystem.Services;


import org.example.electricitybillingsystem.Repository.PastVoltageRepo;
import org.example.electricitybillingsystem.Models.PastVoltages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PastVoltageServices {
    @Autowired
    PastVoltageRepo pvsr;
    @Autowired
    PastVoltages pastVoltages;


    public ResponseEntity<List<PastVoltages>> getPastVoltages() {
        List<PastVoltages> pastVoltages=pvsr.findAll();
        if(pastVoltages.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pastVoltages,HttpStatus.OK);

    }

    public ResponseEntity<HttpStatus> createPastVoltage(PastVoltages pastvoltage) {
        PastVoltages pastvoltage1=pvsr.save(pastvoltage);
        if(pastvoltage1!=null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    public ResponseEntity<List<PastVoltages>> getHomePastVoltages(int id) {
        List<PastVoltages>pastVoltages=pvsr.findByHomeNo(id);
        if(pastVoltages.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pastVoltages,HttpStatus.OK);
    }
}
