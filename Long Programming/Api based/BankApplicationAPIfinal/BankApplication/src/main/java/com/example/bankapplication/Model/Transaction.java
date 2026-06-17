package com.example.bankapplication.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(nullable = false)
    private String transactionType;

    @Column(nullable = false)
    private double transactionAmount;

    private LocalDate date;

    @PrePersist
    public void setDate() {
        this.date = LocalDate.now();
    }

    // Only expose accountNumber and accountHolderName from the linked Account,
    // ignoring the nested transaction lists to prevent infinite recursion
    @ManyToOne
    @JoinColumn(name = "sender_id")
    @JsonIgnoreProperties({"sentTransaction", "receivedTransaction", "customer"})
    private Account senderAccount;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    @JsonIgnoreProperties({"sentTransaction", "receivedTransaction", "customer"})
    private Account receiverAccount;
}
