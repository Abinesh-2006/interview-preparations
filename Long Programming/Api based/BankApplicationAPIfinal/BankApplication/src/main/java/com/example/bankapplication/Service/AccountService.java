package com.example.bankapplication.Service;

import com.example.bankapplication.Model.Account;
import com.example.bankapplication.Repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepo accountRepo;

    public String addAccount(Account account) {
        // Validate required fields
        if (account.getAccountHolderName() == null || account.getAccountHolderName().isBlank()) {
            return "ERROR: Account holder name is required";
        }
        if (account.getAccountNumber() == null || account.getAccountNumber().isBlank()) {
            return "ERROR: Account number is required";
        }
        if (account.getAccountType() == null || account.getAccountType().isBlank()) {
            return "ERROR: Account type is required";
        }
        if (account.getCustomer() == null || account.getCustomer().getCustomerId() == null) {
            return "ERROR: Customer is required";
        }
        if (account.getBalance() < 0) {
            return "ERROR: Opening balance cannot be negative";
        }

        // Duplicate account number check
        if (accountRepo.existsByAccountNumber(account.getAccountNumber())) {
            return "ERROR: An account with this account number already exists";
        }

        accountRepo.save(account);
        return "Account added successfully";
    }

    public List<Account> showAllAccount() {
        return accountRepo.findAll();
    }

    public Account showAccountById(Long id) {
        return accountRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No account found for this id"));
    }

    public String updateAccount(Account account) {
        // Bug fix: was saving detached 'account' object instead of loaded 'exist' entity
        Account exist = accountRepo.findById(account.getAccountId()).orElse(null);
        if (exist == null) {
            return "ERROR: No account found for this id to update";
        }
        exist.setAccountHolderName(account.getAccountHolderName());
        exist.setAccountType(account.getAccountType());
        accountRepo.save(exist); // Fixed: save 'exist', not 'account'
        return "Account updated successfully";
    }

    public String deleteAccountById(Long id) {
        accountRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No account found for this id"));
        accountRepo.deleteById(id);
        return "Account deleted successfully";
    }
}
