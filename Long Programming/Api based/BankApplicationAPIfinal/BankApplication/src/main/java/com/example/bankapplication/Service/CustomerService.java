package com.example.bankapplication.Service;

import com.example.bankapplication.Model.Customer;
import com.example.bankapplication.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public String addCustomer(Customer customer) {
        // Validate required fields
        if (customer.getName() == null || customer.getName().isBlank()) {
            return "ERROR: Name is required";
        }
        if (customer.getEmail() == null || customer.getEmail().isBlank()) {
            return "ERROR: Email is required";
        }
        if (customer.getPhone() == null || customer.getPhone().isBlank()) {
            return "ERROR: Phone is required";
        }
        if (customer.getAddress() == null || customer.getAddress().isBlank()) {
            return "ERROR: Address is required";
        }

        // Duplicate email check
        if (customerRepo.existsByEmail(customer.getEmail())) {
            return "ERROR: A customer with this email already exists";
        }
        // Duplicate phone check
        if (customer.getPhone() != null && !customer.getPhone().isBlank()
                && customerRepo.existsByPhone(customer.getPhone())) {
            return "ERROR: A customer with this phone number already exists";
        }

        customerRepo.save(customer);
        return "Customer added successfully";
    }

    public String deleteCustomer(Long id) {
        if (!customerRepo.existsById(id)) {
            return "ERROR: No customer found for this id";
        }
        customerRepo.deleteById(id);
        return "Customer deleted successfully";
    }

    public List<Customer> showCustomers() {
        return customerRepo.findAll();
    }

    public Customer showCustomerById(Long id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No customer found for this id"));
    }
}
