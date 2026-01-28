package com.smartbank.service;

import com.smartbank.model.BankAccount;
import com.smartbank.repository.AccountRepository;

public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(long accNo, int pin) {
        if (accountRepository.findByAccountNumber(accNo) != null) {
            throw new RuntimeException("Account already exists");
        }

        BankAccount account = new BankAccount(accNo, pin, 0.0);
        accountRepository.save(account);
    }

    public void deposit(BankAccount account, double amount) {
        account.deposit(amount);
    }

    public void withdraw(BankAccount account, double amount) {
        account.withdraw(amount);
    }
}

	
	
	

