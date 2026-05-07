package org.example.electricitybillingsystem.Services;

import org.example.electricitybillingsystem.Repository.HomeRepo;
import org.example.electricitybillingsystem.Models.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServices {

    @Autowired
    HomeRepo hr;

    public ResponseEntity<HttpStatus> createHome(Home home) {
        Home home1 = hr.save(home);
        if (home1 != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<List<Home>> getTheHomes() {
        List<Home> homes = hr.findAll();
        if (homes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }

    public ResponseEntity<Home> getTheHome(int id) {
        Home home = hr.findById(id).orElse(null);
        if (home != null) {
            return new ResponseEntity<>(home, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}