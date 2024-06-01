package com.example.trip_expense_calculation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "expenses")
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    private Long id;
    private String description;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;


}