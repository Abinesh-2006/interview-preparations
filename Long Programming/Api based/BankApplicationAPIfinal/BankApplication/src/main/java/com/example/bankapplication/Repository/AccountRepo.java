package com.example.bankapplication.Repository;

import com.example.bankapplication.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
    // For duplicate account number checking
    boolean existsByAccountNumber(String accountNumber);
}
