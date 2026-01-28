package com.smartbank.excepion;

public class InsufficientBalanceException extends Exception {
	
	public InsufficientBalanceException(String message) {
		super(message);
	}
}
