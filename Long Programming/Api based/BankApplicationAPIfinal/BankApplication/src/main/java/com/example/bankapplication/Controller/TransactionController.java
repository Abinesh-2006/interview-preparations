package com.example.bankapplication.Controller;

import com.example.bankapplication.DTO.TransactionDTO;
import com.example.bankapplication.Model.Transaction;
import com.example.bankapplication.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@CrossOrigin(origins = "*")
public class TransactionController {

    @Autowired
    TransactionService service;

    @PostMapping("/transfer")
    public ResponseEntity<String> transferAmount(@RequestBody TransactionDTO dto) {
        String result = service.transferAmount(dto.getSenderId(), dto.getReceiverId(), dto.getAmount());
        if (result.startsWith("ERROR:")) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/showall")
    public List<Transaction> showAllTransaction() {
        return service.showAllTransaction();
    }

    @PostMapping("/deposit")
    public ResponseEntity<String> depositAmount(@RequestBody TransactionDTO dto) {
        String result = service.depositAmount(dto.getAccountId(), dto.getAmount());
        if (result.startsWith("ERROR:")) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/withdrawal")
    public ResponseEntity<String> withdrawalAmount(@RequestBody TransactionDTO dto) {
        String result = service.withdrawalAmount(dto.getAccountId(), dto.getAmount());
        if (result.startsWith("ERROR:")) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
