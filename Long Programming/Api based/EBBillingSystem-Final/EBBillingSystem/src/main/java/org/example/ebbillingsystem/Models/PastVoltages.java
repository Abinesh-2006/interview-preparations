package org.example.ebbillingsystem.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "past_voltages")
public class PastVoltages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int voltageId;

    Date voltageMonth;
    double voltage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "homeNo")
    Home home;
}
