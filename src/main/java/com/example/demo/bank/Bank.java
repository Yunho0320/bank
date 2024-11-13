package com.example.demo.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bank {

    private final List<AccountListener> listeners = new ArrayList<>();

    // Inject database and cache (or use one depending on your setup)
    private final Database database;  // You may also inject Cache depending on your requirements

    @Autowired
    public Bank(Database database) {
        this.database = database;
    }

    // Deposit money into the account
    public boolean deposit(Account account, Double amount) {
        if (account != null && amount > 0) {
            account.setBalance(account.getBalance() + amount);
            informListeners();  // Notify listeners
            return true;
        }
        return false;  // Invalid account or amount
    }

    // Withdraw money from the account
    public boolean withdraw(Account account, Double amount) {
        if (account != null && amount > 0 && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            informListeners();  // Notify listeners
            return true;
        }
        return false;  // Invalid account, insufficient funds, or invalid amount
    }

    // Get the balance of an account
    public double checkBalance(Account account) {
        if (account != null) {
            return account.getBalance();
        }
        return Double.NaN;  // Return NaN if account not found
    }

    // Add a listener to be notified of account changes
    public void addListener(AccountListener listener) {
        if (listener != null && !listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    // Remove a listener from the notification list
    public void removeListener(AccountListener listener) {
        listeners.remove(listener);
    }

    // Notify all listeners about account changes
    public void informListeners() {
        for (AccountListener listener : listeners) {
            // Here, you can pass the updated account data to the listeners
            listener.onAccountStatusChanged(null);  // You can pass the updated account instead of null
        }
    }

    // Fetch an account from the database or cache
    public Account getAccount(String accountNo) {
        // Try to get from the cache first (if using Cache)
        Account account = null; // This would be from Cache if you are using it
        if (account == null) {
            // If not found in cache, fetch from database
            account = database.getAccount(accountNo);
        }
        return account;
    }
}
