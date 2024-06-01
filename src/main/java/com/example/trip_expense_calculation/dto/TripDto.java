package com.example.trip_expense_calculation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripDto {

    private Long id;
    private String destination;
    private String startDate;
    private String endDate;
}
