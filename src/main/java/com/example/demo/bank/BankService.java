package com.example.demo.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    private final Bank bank; // Inject Bank class

    @Autowired
    public BankService(Bank bank) {
        this.bank = bank;
    }

    // Deposit money to an account
    public boolean depositMoney(String accountNo, double amount) {
        Account account = bank.getAccount(accountNo);  // Get the account by account number
        if (account != null && amount > 0) {
            return bank.deposit(account, amount);  // Call Bank's deposit method
        }
        return false;  // Invalid account or amount
    }

    // Withdraw money from an account
    public boolean withdrawMoney(String accountNo, double amount) {
        Account account = bank.getAccount(accountNo);  // Get the account by account number
        if (account != null && amount > 0 && account.getBalance() >= amount) {
            return bank.withdraw(account, amount);  // Call Bank's withdraw method
        }
        return false;  // Invalid account, insufficient funds, or invalid amount
    }

    // Get the balance of an account
    public double getAccountBalance(String accountNo) {
        Account account = bank.getAccount(accountNo);  // Get the account by account number
        if (account != null) {
            return bank.checkBalance(account);  // Return balance from Bank
        }
        return Double.NaN;  // Return NaN if account not found
    }

    // Add a listener to the bank for account status changes
    public void addAccountListener(AccountListener listener) {
        bank.addListener(listener);  // Call Bank's addListener method
    }

    // Remove a listener from the bank
    public void removeAccountListener(AccountListener listener) {
        bank.removeListener(listener);  // Call Bank's removeListener method
    }
}
