package org.example.electricitybillingsystem.Services;

import jakarta.transaction.Transactional;
import org.example.electricitybillingsystem.Repository.BillingRepo;
import org.example.electricitybillingsystem.Models.Billing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServices {

    @Autowired
    BillingRepo br;

    public ResponseEntity<HttpStatus> createBilling(Billing bill) {
        Billing bill1 = br.save(bill);
        if (bill1 != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<List<Billing>> getBillings() {
        List<Billing> billings = br.findAll();
        if (billings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(billings, HttpStatus.OK);
    }

    public ResponseEntity<Billing> getBilling(int id) {
        Billing bill = br.findById(id).orElse(null);
        if (bill != null) {
            return new ResponseEntity<>(bill, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Transactional
    public ResponseEntity<Billing> settleBill(Billing bill) {
        Billing existing = br.findById(bill.getBillNo()).orElse(null);

        if (existing != null) {
            int n = br.settleBill(
                    bill.getBillNo(),
                    bill.getSettleDate(),
                    bill.getPaymentId()
            );

            if (n > 0) {
                return new ResponseEntity<>(bill, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Billing>> getUnsettledBills(int id) {
        List<Billing> billings = br.getUnsettledBills(id);

        if (!billings.isEmpty()) {
            return new ResponseEntity<>(billings, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // 🔥 FIXED METHOD
    public double calculateBill(double units, String homeType) {
        if (homeType.equalsIgnoreCase("domestic")) {
            return units * 3.5;
        } else {
            return units * 5.0;
        }
    }
}