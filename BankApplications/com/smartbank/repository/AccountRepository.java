package com.smartbank.repository;

import com.smartbank.model.BankAccount;

public interface AccountRepository {
    void save(BankAccount account);
    BankAccount findByAccountNumber(long accountNumber);
}

