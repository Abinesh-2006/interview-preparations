package org.example.ebbillingsystem.Services;

import org.example.ebbillingsystem.Models.PastVoltages;
import org.example.ebbillingsystem.Repository.PastVoltageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PastVoltageServices {

    @Autowired
    PastVoltageRepo pvsr;

    public ResponseEntity<HttpStatus> createPastVoltage(PastVoltages pv) {
        try {
            pvsr.save(pv);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<PastVoltages>> getPastVoltages() {
        List<PastVoltages> list = pvsr.findAll();
        if (list.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public ResponseEntity<List<PastVoltages>> getHomePastVoltages(int id) {
        List<PastVoltages> list = pvsr.findByHomeNo(id);
        if (list.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
