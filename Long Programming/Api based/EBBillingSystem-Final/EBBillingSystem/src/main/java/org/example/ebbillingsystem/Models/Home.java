package org.example.ebbillingsystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "home")
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int homeNo;

    String holderName;
    String homeAddress;
    long holderPhone;
    double currentVoltage;
    String type;

    @JsonIgnore
    @OneToMany(mappedBy = "home", fetch = FetchType.LAZY)
    List<Billing> bills;

    @JsonIgnore
    @OneToMany(mappedBy = "home", fetch = FetchType.LAZY)
    List<PastVoltages> pastVoltages;
}
