package com.cctech.test;
import java.util.Date;
import java.util.List;

public class ExpenseReport {
  public void printReport(List<Expense> expenses) {
	int total = 0;
	int mealExpenses = 0;
	System.out.println("Expenses " + new Date());
	
	for(Expense expense : expenses){
	  if(expense.type == ExpenseType.DINNER || expense.type == ExpenseType.BREAKFAST ||
		 expense.type == ExpenseType.LUNCH){
		mealExpenses += expense.amount;
	  }
	  //	  String expenseName = "";
	  //	  switch(expense.type){
	  //		case DINNER:
	  //		  expenseName = "Dinner";
	  //		  break;
	  //		case BREAKFAST:
	  //		  expenseName = "Breakfast";
	  //		  break;
	  //		case LUNCH:
	  //		  expenseName = "Lunch";
	  //		  break;
	  //		case CAR_RENTAL:
	  //		  expenseName = "Car Rental";
	  //		  break;
	  //	  }
	  
	  String mealOverExpensesMarker = expense.type == ExpenseType.DINNER && expense.amount > 5000 ||
									  expense.type == ExpenseType.BREAKFAST && expense.amount > 1000 ||
									  expense.type == ExpenseType.LUNCH && expense.amount > 2000 ? "X" : " ";
	  
	  System.out.println(expense.type + "\t" + expense.amount + "\t" + mealOverExpensesMarker);
	  
	  total += expense.amount;
	}
	
	System.out.println("Meal expenses: " + mealExpenses);
	System.out.println("Total expenses: " + total);
  }
}
//Add Lunch with an expense limit of 2000.