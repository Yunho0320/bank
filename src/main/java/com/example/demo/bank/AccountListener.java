package com.example.demo.bank;

public interface AccountListener {
    String getAccountNo();
    void onAccountStatusChanged(Account account);
}
