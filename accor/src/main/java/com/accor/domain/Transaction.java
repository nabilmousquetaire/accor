package com.accor.domain;

import com.accor.domain.enums.TransactionType;

import java.util.Date;

// Value Object: Transaction
public class Transaction {
    private Date date;
    private double amount;
    private TransactionType type;
    private double balance;

    public Transaction(double amount, TransactionType type, double balance) {
        this.date = new Date();
        this.amount = amount;
        this.type = type;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return date + " " + type + " " + amount + " " + balance;
    }
}