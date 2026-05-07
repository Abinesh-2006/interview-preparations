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
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int billNo;
    double billAmount;
    long paymentId;
    Date createDate;
    Date settleDate;

    @ManyToOne
    @JoinColumn(name="home_no")
    Home home;
    @ManyToOne
    @JoinColumn(name="center_id")
    ElectricityCenter electricityCenter;


}
