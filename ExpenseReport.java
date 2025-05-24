package com.cctech.test;

import java.util.Date;
import java.util.List;

enum ExpenseType {
    DINNER, BREAKFAST, CAR_RENTAL, LUNCH //added lunch
}

class Expense {
    ExpenseType type;
    int amount;
    int rateLimit;
    public Expense(ExpenseType type, int amount, int rateLimit){
        this.type = type;
        this.amount = amount;
        this.rateLimit = rateLimit;
    }
}

public class ExpenseReport {
    public void printReport(List<Expense> expenses) {
        int total = 0;
        int mealExpenses = 0;

        System.out.println("Expenses " + new Date());

        for (Expense expense : expenses) {
            if (expense.type == ExpenseType.DINNER || expense.type == ExpenseType.BREAKFAST || expense.type == ExpenseType.LUNCH) {
                mealExpenses += expense.amount;
            }

            String expenseName = "";
            switch (expense.type) {
            case DINNER:
                expenseName = "Dinner";
                break;
            case BREAKFAST:
                expenseName = "Breakfast";
                break;
            case CAR_RENTAL:
                expenseName = "Car Rental";
                break;
            case LUNCH:
                expenseName = "Lunch";
                break;
            }

            String mealOverExpensesMarker = expense.amount > expense.rateLimit ? "X" : "";
            //String mealOverExpensesMarker = expense.type == ExpenseType.DINNER && expense.amount > 5000 || expense.type == ExpenseType.BREAKFAST && expense.amount > 1000 || expense.type == ExpenseType.LUNCH && expense.amount > 1000 ? "X" : " ";

            System.out.println(expenseName + "\t" + expense.amount + "\t" + mealOverExpensesMarker);

            total += expense.amount;
        }

        System.out.println("Meal expenses: " + mealExpenses);
        System.out.println("Total expenses: " + total);
    }
    public static void main(String args[]){
        List<Expense> expenses = new ArrayList<>();
        expenses.add(ExpenseType.DINNER, 1000, 5000);
        expenses.add(ExpenseType.BREAKFAST, 2000, 1000);
        expenses.add(ExpenseType.LUNCH, 2000, 1000); // setting the rate limit of lunch to 1000;
    }
}
