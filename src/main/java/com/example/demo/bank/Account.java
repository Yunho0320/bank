package com.example.demo.bank;

public class Account {
    private String accountNo;
    private double balance;
    public Account(){
    }

    public Account(String accountNo){
        this.accountNo = accountNo;
    }
    public String getAccountNo(){
        return accountNo;
    }

    public void setAccountNo(String accountNo){
        this.accountNo = accountNo;
    }

    public double getBalance(){
        return this.balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }
}
