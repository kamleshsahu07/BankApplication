package com.smartbank.service;

import com.smartbank.model.BankAccount;
import com.smartbank.repository.AccountRepository;

public class AuthenticationService {

    private final AccountRepository accountRepository;

    public AuthenticationService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public BankAccount authenticate(long accNo, int pin) {
        BankAccount account = accountRepository.findByAccountNumber(accNo);

        if (account == null || account.getPin() != pin) {
            throw new RuntimeException("Invalid account number or PIN");
        }

        return account;
    }
}

