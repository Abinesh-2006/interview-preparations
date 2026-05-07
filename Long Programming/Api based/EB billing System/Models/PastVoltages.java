package org.example.electricitybillingsystem.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
public class PastVoltages
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int voltageId;

    Date voltageMonth;
    double voltage;

    @ManyToOne
    @JoinColumn(name="homeNo")
    Home home;


}
