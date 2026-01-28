package com.smartbank.app;

import com.smartbank.repository.*;
import com.smartbank.service.*;
import com.smartbank.app.*;

public class BankApplication {

    public static void main(String[] args) {

        AccountRepository accountRepository = new AccountRepositoryImpl();

        AccountService accountService =
                new AccountService(accountRepository);

        AuthenticationService authenticationService =
                new AuthenticationService(accountRepository);

        Menu menu = new Menu(accountService, authenticationService);
        menu.start();
    }
}
