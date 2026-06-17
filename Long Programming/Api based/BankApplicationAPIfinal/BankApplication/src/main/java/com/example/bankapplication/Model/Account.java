package com.example.bankapplication.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(nullable = false)
    private String accountHolderName;

    @Column(nullable = false, unique = true)
    private String accountNumber;

    @Column(nullable = false)
    private String accountType;

    private double balance;

    // Keep customer info visible (customerId needed for frontend display)
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    // JsonIgnore breaks Account → Transaction → Account infinite loop
    @JsonIgnore
    @OneToMany(mappedBy = "senderAccount", cascade = CascadeType.ALL)
    private List<Transaction> sentTransaction;

    @JsonIgnore
    @OneToMany(mappedBy = "receiverAccount", cascade = CascadeType.ALL)
    private List<Transaction> receivedTransaction;
}
