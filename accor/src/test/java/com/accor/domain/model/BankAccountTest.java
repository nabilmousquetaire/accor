package com.accor.domain.model;

import com.accor.domain.BankAccount;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BankAccountTest {
    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount(UUID.randomUUID().toString(), 10000);
    }

    @Test
    public void testDeposit() {
        account.deposit(10000);
        assertEquals(20000, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawal() {
        account.withdraw(3000);
        assertEquals(7000, account.getBalance(), 0.001);
    }

    @Test
    public void testPrintStatement() {
        assertDoesNotThrow(() -> account.printStatement());
    }
}