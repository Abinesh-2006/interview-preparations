package org.example.electricitybillingsystem.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Component
public class ElectricityCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int centerId;

    String CenterBranch;
    String centerLocation;
    long centerPhoneNo;
    String centerMail;

    @OneToMany(mappedBy = "electricityCenter")
    List<Billing> bills;


}
