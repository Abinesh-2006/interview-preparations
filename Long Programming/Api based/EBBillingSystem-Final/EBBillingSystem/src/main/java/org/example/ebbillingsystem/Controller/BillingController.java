package org.example.ebbillingsystem.Controller;

import org.example.ebbillingsystem.Models.Billing;
import org.example.ebbillingsystem.PassingModels.CalculateAmount;
import org.example.ebbillingsystem.Services.BillServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BillingController {

    @Autowired BillServices service;

    @PostMapping("/calculate")
    public double calculate(@RequestBody CalculateAmount request) {
        return service.calculateBill(request.getUnits(), request.getHomeType());
    }

    @PostMapping("/create/billing")
    public ResponseEntity<?> createBilling(@RequestBody Billing bill) {
        return service.createBilling(bill);
    }

    @GetMapping("/bills")
    public ResponseEntity<List<Billing>> getBillings() {
        return service.getBillings();
    }

    @GetMapping("/bill/{id}")
    public ResponseEntity<Billing> getBilling(@PathVariable int id) {
        return service.getBilling(id);
    }

    @PutMapping("/settle/bill")
    public ResponseEntity<Billing> settleBilling(@RequestBody Billing bill) {
        return service.settleBill(bill);
    }
}
