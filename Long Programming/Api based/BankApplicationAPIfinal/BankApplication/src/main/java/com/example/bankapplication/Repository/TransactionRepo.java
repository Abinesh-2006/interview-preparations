package com.example.bankapplication.Repository;

import com.example.bankapplication.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction,Long> {
}
