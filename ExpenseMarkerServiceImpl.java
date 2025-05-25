package com.cctech.test;

public class ExpenseMarkerServiceImpl implements ExpenseMarkerService{
    @Override
    public String getMarker(Expense expense) {

        if( expense.type == ExpenseType.DINNER && expense.amount > 5000 || expense.type == ExpenseType.BREAKFAST && expense.amount > 1000 ||  expense.type == ExpenseType.LUNCH && expense.amount > 2000) {
            return "X";
        }
        return "Under Limit";
    }
}
