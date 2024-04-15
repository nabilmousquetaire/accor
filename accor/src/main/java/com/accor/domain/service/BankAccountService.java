package com.accor.domain.service;

import com.accor.domain.BankAccount;

public class BankAccountService {

    public void deposit(BankAccount account, double amount) {
        account.deposit(amount);
    }

    public void withdraw(BankAccount account, double amount) {
        if (account.getBalance() >= amount) {
            account.withdraw(amount);
        } else {
            throw new IllegalArgumentException("Balance insuffisante");
        }
    }

}