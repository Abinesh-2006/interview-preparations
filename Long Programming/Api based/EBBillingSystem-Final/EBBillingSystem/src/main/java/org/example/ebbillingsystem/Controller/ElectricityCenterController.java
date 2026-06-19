package org.example.ebbillingsystem.Controller;

import org.example.ebbillingsystem.Models.ElectricityCenter;
import org.example.ebbillingsystem.Services.EcServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ElectricityCenterController {

    @Autowired EcServices es;

    @PostMapping("/create/electricitycenter")
    public ResponseEntity<HttpStatus> createElectricityCenter(@RequestBody ElectricityCenter ec) {
        return es.createElectricityCenter(ec);
    }

    @GetMapping("/centers")
    public ResponseEntity<List<ElectricityCenter>> getElectricityCenters() {
        return es.getElectricityCenters();
    }

    @GetMapping("/center/{id}")
    public ResponseEntity<ElectricityCenter> getElectricityCenter(@PathVariable int id) {
        return es.getElectricityCenter(id);
    }
}
