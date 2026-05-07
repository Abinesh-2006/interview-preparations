package org.example.electricitybillingsystem.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int homeNo;
    String holderName;
    String homeAddress;
    long holderPhone;
    double currentVoltage;
    String type;


    @OneToMany(mappedBy = "home")
    List<Billing> bills;

    @OneToMany(mappedBy = "home")
    List<PastVoltages> pastVoltages;
}
