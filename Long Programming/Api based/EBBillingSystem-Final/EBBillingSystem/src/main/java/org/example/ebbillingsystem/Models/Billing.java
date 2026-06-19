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
@Table(name = "billing")
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int billNo;

    double billAmount;
    long paymentId;
    Date createDate;
    Date settleDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "home_no")
    Home home;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "center_id")
    ElectricityCenter electricityCenter;
}
