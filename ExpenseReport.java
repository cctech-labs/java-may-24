package com.cctech.test;

import java.util.Date;
import java.util.List;

enum ExpenseType {
    DINNER, BREAKFAST, CAR_RENTAL
}

class Expense {
    private final ExpenseType type;
    private final int amount;

    public Expense(ExpenseType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public ExpenseType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }
}

public class ExpenseReport {
    public void printReport(List<Expense> expenses) {
        if (expenses == null || expenses.isEmpty()) {
            System.out.println("No expenses to report.");
            return;
        }

        int total = 0;
        int mealExpenses = 0;

        System.out.println("Expenses " + new Date());
        System.out.println("Category\tAmount\tOver Limit");

        for (Expense expense : expenses) {
            ExpenseType type = expense.getType();
            int amount = expense.getAmount();

            if (type == ExpenseType.DINNER || type == ExpenseType.BREAKFAST) {
                mealExpenses += amount;
            }

            String expenseName;
            switch (type) {
                case DINNER:
                    expenseName = "Dinner";
                    break;
                case BREAKFAST:
                    expenseName = "Breakfast";
                    break;
                case CAR_RENTAL:
                    expenseName = "Car Rental";
                    break;
                default:
                    expenseName = "Other";
            }

            String overLimitMarker = (type == ExpenseType.DINNER && amount > 5000) ||
                                     (type == ExpenseType.BREAKFAST && amount > 1000) ? "X" : " ";

            System.out.printf("%-12s\t%d\t%s%n", expenseName, amount, overLimitMarker);
            total += amount;
        }

        System.out.println("Meal expenses: " + mealExpenses);
        System.out.println("Total expenses: " + total);
    }
}





