package org.example.ebbillingsystem.Services;

import jakarta.transaction.Transactional;
import org.example.ebbillingsystem.Models.Billing;
import org.example.ebbillingsystem.Repository.BillingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServices {

    @Autowired
    BillingRepo br;

    public ResponseEntity<?> createBilling(Billing bill) {
        try {
            br.save(bill);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Billing>> getBillings() {
        List<Billing> list = br.findAll();
        if (list.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public ResponseEntity<Billing> getBilling(int id) {
        return br.findById(id)
                .map(b -> new ResponseEntity<>(b, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Transactional
    public ResponseEntity<Billing> settleBill(Billing bill) {
        if (!br.existsById(bill.getBillNo())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        int updated = br.settleBill(bill.getBillNo(), bill.getSettleDate(), bill.getPaymentId());
        if (updated > 0) return new ResponseEntity<>(bill, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<List<Billing>> getUnsettledBills(int homeId) {
        List<Billing> list = br.getUnsettledBills(homeId);
        if (list.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // Slab-based bill calculation (TNEB domestic slabs)
    public double calculateBill(double units, String homeType) {
        if (homeType == null || homeType.isBlank()) {
            throw new IllegalArgumentException("homeType must be 'domestic' or 'commercial'");
        }
        if (homeType.equalsIgnoreCase("domestic")) {
            if (units <= 100) return 0;
            if (units <= 200) return (units - 100) * 1.50;
            if (units <= 500) return (100 * 1.50) + (units - 200) * 3.00;
            return (100 * 1.50) + (300 * 3.00) + (units - 500) * 5.00;
        }
        return units * 5.00; // commercial flat rate
    }
}
