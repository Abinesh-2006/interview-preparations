package com.example.bankapplication.Controller;

import com.example.bankapplication.Model.Customer;
import com.example.bankapplication.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping("/add")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        String result = service.addCustomer(customer);
        if (result.startsWith("ERROR:")) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        String result = service.deleteCustomer(id);
        if (result.startsWith("ERROR:")) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public List<Customer> showCustomers() {
        return service.showCustomers();
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<?> showCustomerById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.showCustomerById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
