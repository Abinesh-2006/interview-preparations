package org.example.electricitybillingsystem.PassingModels;

import lombok.Data;

@Data
public class CalculateAmount {
    private double units;
    private String homeType;
}