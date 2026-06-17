package com.example.bankapplication.DTO;

import lombok.Data;

@Data
public class TransactionDTO {
    private Long senderId;
    private Long receiverId;
    private Double amount;
    private Long accountId;
}
