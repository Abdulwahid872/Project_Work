package com.example.trip_expense_calculation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDto {

    private Long id;
    private String description;
    private Double amount;
    private TripDto trip;
}
