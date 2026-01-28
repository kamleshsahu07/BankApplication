package com.smartbank.model;

public class BankAccount {
    private final long accountNumber;
    private final int pin;
    private double balance;

    public BankAccount(long accountNumber, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new RuntimeException("Insufficient balance");
        }
        balance -= amount;
    }

	
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	