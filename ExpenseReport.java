package com.cctech.test;


import java.util.Date;
import java.util.List;
import java.util.ArrayList;

enum ExpenseType {
    DINNER, BREAKFAST, CAR_RENTAL
}

class Expense {
    ExpenseType type;
    int amount;

    public Expense(ExpenseType type, int amount) {
        this.type = type;
        this.amount = amount;
    }
}

// Expense validator following SRP
class ExpenseValidator {
    public boolean isMealOverExpense(Expense expense) {
        return (expense.type == ExpenseType.DINNER && expense.amount > 5000) ||
               (expense.type == ExpenseType.BREAKFAST && expense.amount > 1000);
    }
}

// Expense calculator following SRP
class ExpenseCalculator {
    public int calculateTotal(List<Expense> expenses) {
        return expenses.stream()
                      .mapToInt(expense -> expense.amount)
                      .sum();
    }

public int calculateMealExpenses(List<Expense> expenses) {
        return expenses.stream()
                      .filter(expense -> expense.type == ExpenseType.DINNER || 
                                       expense.type == ExpenseType.BREAKFAST)
                      .mapToInt(expense -> expense.amount)
                      .sum();
    }
}

// Expense formatter following SRP
class ExpenseFormatter {
    public String formatExpenseType(ExpenseType type) {
        switch (type) {
            case DINNER: return "Dinner";
            case BREAKFAST: return "Breakfast";
            case CAR_RENTAL: return "Car Rental";
            default: return "";
        }
    }
}

// Main ExpenseReport class now delegates to specialized classes
public class ExpenseReport {
    private final ExpenseValidator validator;
    private final ExpenseCalculator calculator;
    private final ExpenseFormatter formatter;

    public ExpenseReport() {
        this.validator = new ExpenseValidator();
        this.calculator = new ExpenseCalculator();
        this.formatter = new ExpenseFormatter();
    }

public void printReport(List<Expense> expenses) {
        System.out.println("Expenses " + new Date());

        for (Expense expense : expenses) {
            String expenseName = formatter.formatExpenseType(expense.type);
            String mealOverExpensesMarker = validator.isMealOverExpense(expense) ? "X" : " ";
            System.out.println(expenseName + "\t" + expense.amount + "\t" + mealOverExpensesMarker);
        }

        int mealExpenses = calculator.calculateMealExpenses(expenses);
        int total = calculator.calculateTotal(expenses);

        System.out.println("Meal expenses: " + mealExpenses);
        System.out.println("Total expenses: " + total);
    }

    
}
