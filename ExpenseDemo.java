package com.cctech.test;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDemo {
  public static void main(String[] args) {
	Expense e1 = new Expense(ExpenseType.LUNCH, 3000);
	Expense e2 = new Expense(ExpenseType.DINNER, 6000);
	Expense e3 = new Expense(ExpenseType.CAR_RENTAL, 7000);
	Expense e4 = new Expense(ExpenseType.BREAKFAST, 5000);
	
	List<Expense> expenses = new ArrayList<>();
	expenses.add(e1);
	expenses.add(e2);
	expenses.add(e3);
	expenses.add(e4);
	
	ExpenseReport expenseReport = new ExpenseReport();
	expenseReport.printReport(expenses);
  }
}