package org.example.ebbillingsystem.Controller;

import org.example.ebbillingsystem.Models.Billing;
import org.example.ebbillingsystem.Models.Home;
import org.example.ebbillingsystem.Services.BillServices;
import org.example.ebbillingsystem.Services.HomeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired HomeServices hs;
    @Autowired BillServices bs;

    @PostMapping("/create/home")
    public ResponseEntity<HttpStatus> createHome(@RequestBody Home home) {
        return hs.createHome(home);
    }

    @GetMapping("/homes")
    public ResponseEntity<List<Home>> getHomes() {
        return hs.getTheHomes();
    }

    @GetMapping("/home/{id}")
    public ResponseEntity<Home> getHome(@PathVariable int id) {
        return hs.getTheHome(id);
    }

    @GetMapping("/unsettled/bills/{id}")
    public ResponseEntity<List<Billing>> unsettledBills(@PathVariable int id) {
        return bs.getUnsettledBills(id);
    }
}
