package com.example.bankapplication.Controller;

import com.example.bankapplication.Model.Account;
import com.example.bankapplication.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "*")
public class AccountController {

    @Autowired
    AccountService service;

    @PostMapping("/create")
    public ResponseEntity<String> addAccount(@RequestBody Account account) {
        String result = service.addAccount(account);
        if (result.startsWith("ERROR:")) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAccount(@RequestBody Account account) {
        String result = service.updateAccount(account);
        if (result.startsWith("ERROR:")) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/showall")
    public List<Account> showAllAccounts() {
        return service.showAllAccount();
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<?> showAccountById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.showAccountById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        try {
            String result = service.deleteAccountById(id);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
