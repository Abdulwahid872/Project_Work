package com.example.trip_expense_calculation.repository;

import com.example.trip_expense_calculation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
