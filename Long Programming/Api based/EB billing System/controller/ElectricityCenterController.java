package org.example.electricitybillingsystem.controller;

import org.example.electricitybillingsystem.Models.ElectricityCenter;
import org.example.electricitybillingsystem.Services.EcServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ElectricityCenterController {
    @Autowired
    EcServices es;
    @Autowired
    ElectricityCenter electricityCenter;
    @PostMapping("create/electricitycenter")
    public ResponseEntity<HttpStatus> createElectricityCenter(@RequestBody ElectricityCenter electricityCenter){
        return es.createElectricityCenter(electricityCenter);
    }
    @GetMapping("/centers")
    public ResponseEntity<List<ElectricityCenter>> getElectricityCenters(){
        return es.getElectricityCenters();
    }
    @GetMapping("/center/{id}")
    public ResponseEntity<ElectricityCenter> getElectricityCenters(@PathVariable int id){
        return es.getElectricityCenter(id);
    }




}
