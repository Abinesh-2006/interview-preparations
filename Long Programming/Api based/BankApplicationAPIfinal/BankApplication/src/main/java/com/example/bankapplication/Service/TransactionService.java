package com.example.bankapplication.Service;

import com.example.bankapplication.Model.Account;
import com.example.bankapplication.Model.Transaction;
import com.example.bankapplication.Repository.AccountRepo;
import com.example.bankapplication.Repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Fixed: was jakarta.transaction.Transactional (wrong import)

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    AccountRepo accountRepo;

    @Transactional
    public String transferAmount(Long senderId, Long receiverId, Double amount) {
        if (amount == null || amount <= 0) {
            return "ERROR: Amount must be greater than zero";
        }
        if (senderId == null || receiverId == null) {
            return "ERROR: Sender and receiver accounts are required";
        }
        if (senderId.equals(receiverId)) {
            return "ERROR: Sender and receiver account cannot be the same";
        }

        Account senderAccount = accountRepo.findById(senderId)
                .orElseThrow(() -> new RuntimeException("Sender account not found"));
        Account receiverAccount = accountRepo.findById(receiverId)
                .orElseThrow(() -> new RuntimeException("Receiver account not found"));

        if (senderAccount.getBalance() < amount) {
            return "ERROR: Insufficient balance";
        }

        senderAccount.setBalance(senderAccount.getBalance() - amount);
        receiverAccount.setBalance(receiverAccount.getBalance() + amount);
        accountRepo.save(senderAccount);
        accountRepo.save(receiverAccount);

        Transaction transaction = new Transaction();
        transaction.setSenderAccount(senderAccount);
        transaction.setReceiverAccount(receiverAccount);
        transaction.setTransactionAmount(amount);
        transaction.setTransactionType("TRANSFER");
        transactionRepo.save(transaction);

        return "Transaction Successful";
    }

    @Transactional
    public String depositAmount(Long id, Double amount) {
        if (amount == null || amount <= 0) {
            return "ERROR: Amount must be greater than zero";
        }
        if (id == null) {
            return "ERROR: Account is required";
        }

        Account account = accountRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        accountRepo.save(account);

        Transaction transaction = new Transaction();
        transaction.setTransactionType("DEPOSIT");
        transaction.setTransactionAmount(amount);
        transaction.setReceiverAccount(account);
        transactionRepo.save(transaction);

        return "Amount successfully deposited to " + account.getAccountNumber();
    }

    @Transactional
    public String withdrawalAmount(Long id, Double amount) {
        if (amount == null || amount <= 0) {
            return "ERROR: Amount must be greater than zero";
        }
        if (id == null) {
            return "ERROR: Account is required";
        }

        Account account = accountRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance() < amount) {
            return "ERROR: Insufficient balance";
        }

        account.setBalance(account.getBalance() - amount);
        accountRepo.save(account);

        Transaction transaction = new Transaction();
        transaction.setTransactionType("WITHDRAWAL");
        transaction.setSenderAccount(account);
        transaction.setTransactionAmount(amount);
        transactionRepo.save(transaction);

        return "Amount successfully debited from " + account.getAccountNumber();
    }

    public List<Transaction> showAllTransaction() {
        return transactionRepo.findAll();
    }
}
