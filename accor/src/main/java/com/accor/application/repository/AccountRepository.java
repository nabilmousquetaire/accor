package com.accor.application.repository;

import com.accor.domain.Transaction;
import com.accor.domain.enums.TransactionType;
import com.accor.domain.BankAccount;

import java.util.List;

public interface AccountRepository {
    BankAccount findAccountById(String id);
    void save(BankAccount account);
    void saveTransaction(String id, Double amount, TransactionType transactionType, Double balance);
    List<Transaction> getAllTransactions(String accountId);
}