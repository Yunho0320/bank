package com.example.demo.bank;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Cache {
    private final Map<String, Account> cache = new HashMap<>();

    // Simulating cache load only when an account is accessed
    public Account getAccount(String accountNo) {
        return cache.get(accountNo); // Return the account from cache if present
    }

    public void addAccountToCache(Account account) {
        cache.put(account.getAccountNo(), account); // Add account to cache
    }

    public void updateAccount(Account account) {
        cache.put(account.getAccountNo(), account); // Update account in cache
    }

    public boolean contains(String accountNo) {
        return cache.containsKey(accountNo); // Check if account exists in cache
    }
}
