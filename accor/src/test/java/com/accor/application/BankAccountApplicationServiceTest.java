package com.accor.application;

import com.accor.application.repository.AccountRepository;
import com.accor.application.repository.InMemoryAccountRepository;
import com.accor.application.service.BankAccountApplicationService;
import com.accor.domain.BankAccount;
import com.accor.domain.service.BankAccountService;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class BankAccountApplicationServiceTest {
    private BankAccountApplicationService bankAccountApplicationService;
    private BankAccountService bankAccountService;
    private AccountRepository accountRepository;


    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount(UUID.randomUUID().toString(), 10000);
        bankAccountService = new BankAccountService();
        bankAccountApplicationService = new BankAccountApplicationService(new BankAccountService(), new InMemoryAccountRepository());
    }

    @Test
    public void testDeposit() {
        bankAccountApplicationService.depositMoney(account.getAccountId(), 5000);
        assertEquals(15000, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        bankAccountApplicationService.withdrawMoney(account.getAccountId(), 5000);
        assertEquals(5000, account.getBalance(), 0.001);
    }
}