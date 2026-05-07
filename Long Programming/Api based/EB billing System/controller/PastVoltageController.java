package org.example.electricitybillingsystem.controller;
import org.example.electricitybillingsystem.Models.PastVoltages;
import org.example.electricitybillingsystem.Services.PastVoltageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PastVoltageController {
    @Autowired
    PastVoltageServices ps;
    @Autowired
    PastVoltages pastVoltages;
    @PostMapping("create/pastvoltage")
    public ResponseEntity<HttpStatus> createPastVoltage(@RequestBody PastVoltages pastvoltage){
        return ps.createPastVoltage(pastvoltage);
    }
    @GetMapping("/voltages")
    public ResponseEntity<List<PastVoltages>> getPastVoltages(){
        return ps.getPastVoltages();
    }
    @GetMapping("/voltages/{id}")
    public ResponseEntity<List<PastVoltages>> getHomesPastVoltages(@PathVariable int id ){
        return ps.getHomePastVoltages(id);
    }
}
