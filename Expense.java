package com.cctech.test;
public class Expense {
  ExpenseType type;
  int amount;
  
  Expense(ExpenseType type, int amount) {
	this.type = type;
	this.amount = amount;
  }
  // we can use getter and setters also to optimize the control
}