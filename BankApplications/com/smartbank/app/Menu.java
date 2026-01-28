package com.smartbank.app;

import com.smartbank.model.BankAccount;
import com.smartbank.service.AccountService;
import com.smartbank.service.AuthenticationService;

import java.util.Scanner;

public class Menu {

    private final AccountService accountService;
    private final AuthenticationService authenticationService;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(AccountService accountService,
                AuthenticationService authenticationService) {
        this.accountService = accountService;
        this.authenticationService = authenticationService;
    }

    public void start() {
        while (true) {
            System.out.println("\n--- SMART BANK ---");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> login();
                case 3 -> {
                    System.out.println("Thank you for using SmartBank");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    private void createAccount() {
        System.out.print("Enter account number: ");
        long accNo = scanner.nextLong();

        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();

        accountService.createAccount(accNo, pin);
        System.out.println("✅ Account created successfully");
    }

    private void login() {
        System.out.print("Enter account number: ");
        long accNo = scanner.nextLong();

        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();

        BankAccount account =
                authenticationService.authenticate(accNo, pin);

        System.out.println("✅ Login successful");
        customerMenu(account);
    }

    // 🔽 NEXT MENU (REQUESTED)
    private void customerMenu(BankAccount account) {
        while (true) {
            System.out.println("\n--- CUSTOMER MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Logout");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Amount: ");
                    double amt = scanner.nextDouble();
                    accountService.deposit(account, amt);
                    System.out.println("✅ Deposited");
                }
                case 2 -> {
                    System.out.print("Amount: ");
                    double amt = scanner.nextDouble();
                    accountService.withdraw(account, amt);
                    System.out.println("✅ Withdrawn");
                }
                case 3 ->
                    System.out.println("Balance: ₹" + account.getBalance());
                case 4 -> {
                    System.out.println("Logged out");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}


