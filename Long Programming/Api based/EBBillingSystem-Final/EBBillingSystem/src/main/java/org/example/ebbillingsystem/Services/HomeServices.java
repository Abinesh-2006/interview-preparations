package org.example.ebbillingsystem.Services;

import org.example.ebbillingsystem.Models.Home;
import org.example.ebbillingsystem.Repository.HomeRepo;
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
        try {
            hr.save(home);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Home>> getTheHomes() {
        List<Home> homes = hr.findAll();
        if (homes.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }

    public ResponseEntity<Home> getTheHome(int id) {
        return hr.findById(id)
                .map(h -> new ResponseEntity<>(h, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
