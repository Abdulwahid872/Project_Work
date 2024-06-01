package com.example.trip_expense_calculation.service;

import com.example.trip_expense_calculation.dto.ExpenseDto;
import com.example.trip_expense_calculation.dto.TripDto;
import com.example.trip_expense_calculation.model.Expense;
import com.example.trip_expense_calculation.model.Trip;
import com.example.trip_expense_calculation.repository.ExpenseRepository;
import com.example.trip_expense_calculation.repository.TripRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculationService {

    @Autowired
    private TripRepository tripRepo;

    @Autowired
    private ExpenseRepository expenseRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<TripDto> getAllTrips() {
        return tripRepo.findAll().stream()
                .map(trip -> modelMapper.map(trip, TripDto.class))
                .collect(Collectors.toList());
    }

    public TripDto createTrip(TripDto tripDto) {
        Trip trip = modelMapper.map(tripDto, Trip.class);
        Trip savedTrip = tripRepo.save(trip);
        return modelMapper.map(savedTrip, TripDto.class);
    }

    public TripDto updateTrip(Long id, TripDto tripDto) {
        Trip trip = tripRepo.findById(id).orElseThrow(() -> new RuntimeException("Trip not found"));
        trip.setDestination(tripDto.getDestination());
        trip.setStartDate(tripDto.getStartDate());
        trip.setEndDate(tripDto.getEndDate());
        Trip updatedTrip = tripRepo.save(trip);
        return modelMapper.map(updatedTrip, TripDto.class);
    }

    public void deleteTrip(Long id) {
        tripRepo.deleteById(id);
    }

    public List<ExpenseDto> getAllExpenses() {
        return expenseRepo.findAll().stream()
                .map(expense -> modelMapper.map(expense, ExpenseDto.class))
                .collect(Collectors.toList());
    }

    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense expense = modelMapper.map(expenseDto, Expense.class);
        expense.setTrip(tripRepo.findById(expenseDto.getTrip().getId())
                .orElseThrow(() -> new RuntimeException("Trip not found")));
        Expense savedExpense = expenseRepo.save(expense);
        return modelMapper.map(savedExpense, ExpenseDto.class);
    }

    public ExpenseDto updateExpense(Long id, ExpenseDto expenseDto) {
        Expense expense = expenseRepo.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
        expense.setDescription(expenseDto.getDescription());
        expense.setAmount(expenseDto.getAmount());
        Expense updatedExpense = expenseRepo.save(expense);
        return modelMapper.map(updatedExpense, ExpenseDto.class);
    }

    public void deleteExpense(Long id) {
        expenseRepo.deleteById(id);
    }
}
