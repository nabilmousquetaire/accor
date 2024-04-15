package com.accor.application.service;

import com.accor.application.repository.AccountRepository;
import com.accor.domain.enums.TransactionType;
import com.accor.domain.BankAccount;
import com.accor.domain.service.BankAccountService;

public class BankAccountApplicationService {
    private final AccountRepository accountRepository;
    private final BankAccountService bankAccountService;

    public BankAccountApplicationService(BankAccountService bankAccountService, AccountRepository accountRepository) {
        this.bankAccountService = bankAccountService;
        this.accountRepository = accountRepository;
    }

    public void depositMoney(String accountId, double amount) {
        BankAccount account = accountRepository.findAccountById(accountId);
        if (account != null) {
            bankAccountService.deposit(account, amount);
            accountRepository.saveTransaction(account.getAccountId(), amount, TransactionType.DEPOSIT, account.getBalance());
        } else {
            throw new IllegalArgumentException("Account not found");
        }
    }

    public void withdrawMoney(String accountId, double amount) {
        BankAccount account = accountRepository.findAccountById(accountId);
        if (account != null) {
            bankAccountService.withdraw(account, amount);
            accountRepository.saveTransaction(account.getAccountId(), amount, TransactionType.WITHDRAWAL, account.getBalance());
        } else {
            throw new IllegalArgumentException("Account not found");
        }
    }
}