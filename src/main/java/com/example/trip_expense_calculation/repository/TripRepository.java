package com.example.trip_expense_calculation.repository;

import com.example.trip_expense_calculation.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
