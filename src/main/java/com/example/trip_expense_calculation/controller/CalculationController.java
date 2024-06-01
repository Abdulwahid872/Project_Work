package com.example.trip_expense_calculation.controller;

import com.example.trip_expense_calculation.dto.ExpenseDto;
import com.example.trip_expense_calculation.dto.TripDto;
import com.example.trip_expense_calculation.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CalculationController {

    @Autowired
    private CalculationService calculationService;

    @GetMapping("/trips")
    public List<TripDto> getAllTrips() {
        return calculationService.getAllTrips();
    }

    @PostMapping("/trips")
    public TripDto createTrip(@RequestBody TripDto tripDto) {
        return calculationService.createTrip(tripDto);
    }

    @PutMapping("/trips/{id}")
    public TripDto updateTrip(@PathVariable Long id, @RequestBody TripDto tripDto) {
        return calculationService.updateTrip(id, tripDto);
    }

    @DeleteMapping("/trips/{id}")
    public void deleteTrip(@PathVariable Long id) {
        calculationService.deleteTrip(id);
    }

    @GetMapping("/expenses")
    public List<ExpenseDto> getAllExpenses() {
        return calculationService.getAllExpenses();
    }

    @PostMapping("/expenses")
    public ExpenseDto createExpense(@RequestBody ExpenseDto expenseDto) {
        return calculationService.createExpense(expenseDto);
    }

    @PutMapping("/expenses/{id}")
    public ExpenseDto updateExpense(@PathVariable Long id, @RequestBody ExpenseDto expenseDto) {
        return calculationService.updateExpense(id, expenseDto);
    }

    @DeleteMapping("/expenses/{id}")
    public void deleteExpense(@PathVariable Long id) {
        calculationService.deleteExpense(id);
    }
}
