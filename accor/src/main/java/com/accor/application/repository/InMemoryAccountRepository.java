package com.accor.application.repository;

import com.accor.domain.BankAccount;
import com.accor.domain.Transaction;
import com.accor.domain.enums.TransactionType;

import java.util.List;

public class InMemoryAccountRepository implements AccountRepository {

    @Override
    public BankAccount findAccountById(String id) {
        return null;
    }

    @Override
    public void save(BankAccount account) {

    }

    @Override
    public void saveTransaction(String id, Double amount, TransactionType transactionType, Double balance) {

    }

    @Override
    public List<Transaction> getAllTransactions(String accountId) {
        return List.of();
    }
}