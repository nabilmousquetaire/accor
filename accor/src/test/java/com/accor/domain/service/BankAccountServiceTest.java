package com.accor.domain.service;


import com.accor.domain.BankAccount;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class BankAccountServiceTest {
    private BankAccountService bankAccountService;
    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount(UUID.randomUUID().toString(), 10000);
        bankAccountService = new BankAccountService();
    }

    @Test
    public void testDeposit() {
        bankAccountService.deposit(account, 5000);
        assertEquals(15000, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        bankAccountService.withdraw(account, 5000);
        assertEquals(5000, account.getBalance(), 0.001);
    }
}