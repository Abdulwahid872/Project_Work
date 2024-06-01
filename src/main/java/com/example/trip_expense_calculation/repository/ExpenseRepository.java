package com.example.trip_expense_calculation.repository;

import com.example.trip_expense_calculation.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
}
