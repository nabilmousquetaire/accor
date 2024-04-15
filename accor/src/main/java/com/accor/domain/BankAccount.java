package com.accor.domain;

import com.accor.domain.enums.TransactionType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

// Entity: Bank Account
@Data
public class BankAccount {
    private String accountId;
    private double balance = 0;
    private List<Transaction> transactions = new ArrayList<>();


    public BankAccount(String accountId, double initialBalance) {
        this.balance = initialBalance;
        this.accountId = accountId;
    }

    public BankAccount() {

    }

    // Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction(amount, TransactionType.DEPOSIT, balance));
        }
    }

    // Withdrawal
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction(amount, TransactionType.WITHDRAWAL, balance));
        }
    }

    // Print Statement
    public void printStatement() {
        System.out.println("Print Statements : \n");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

}
