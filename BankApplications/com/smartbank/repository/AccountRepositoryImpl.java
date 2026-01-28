package com.smartbank.repository;

import com.smartbank.model.BankAccount;
import com.smartbank.repository.AccountRepository;

import java.util.HashMap;
import java.util.Map;

public class AccountRepositoryImpl implements AccountRepository {

    private final Map<Long, BankAccount> accounts = new HashMap<>();

    @Override
    public void save(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    @Override
    public BankAccount findByAccountNumber(long accountNumber) {
        return accounts.get(accountNumber);
    }
}

