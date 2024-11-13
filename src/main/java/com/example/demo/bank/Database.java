package com.example.demo.bank;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Database {
    private final Map<Integer, Account> database = new HashMap<>();

    public Database() {
        // Initialize accounts with account numbers 1 through 100
        for (int i = 1; i <= 100; i++) {
            Account account = new Account();
            account.setAccountNo(String.valueOf(i));
            account.setBalance(10*i);
            database.put(account.hashCode(), account);
        }
    }

    public Account getAccount(String accountNo) {
        return database.get(accountNo);
    }

    public void updateAccount(Account account) {
        database.put(account.hashCode(), account);
    }
}
