package com.example.userinput.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserModel {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;
    String userName;
    String userPh;
    int userAge;
    String userDept;
    String YearOfPass;
}
