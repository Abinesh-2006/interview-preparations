package org.example.ebbillingsystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "electricity_center")
public class ElectricityCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int centerId;

    String CenterBranch;
    String centerLocation;
    long centerPhoneNo;
    String centerMail;

    @JsonIgnore
    @OneToMany(mappedBy = "electricityCenter", fetch = FetchType.LAZY)
    List<Billing> bills;
}
