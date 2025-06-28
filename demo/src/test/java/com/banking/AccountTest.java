package com.banking;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.banking.entity.Account;
import com.banking.service.AccountService;

class AccountTest {

    private AccountService account;

    @BeforeEach
    void setUp() {
        account = new Account();
    }

    @Test
    void deposit_should_add_positive_amount() {
        account.deposit(1000);
        account.deposit(2000);
        // Pas d'exception attendue ? test réussi
    }

    @Test
    void deposit_should_throw_exception_for_zero_or_negative_amount() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-500));
    }

    @Test
    void withdraw_should_subtract_valid_amount() {
        account.deposit(1000);
        account.withdraw(500);
        // Pas d'exception attendue ? test réussi
    }

    @Test
    void withdraw_should_throw_exception_if_insufficient_balance() {
        account.deposit(1000);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(1500));
    }

    @Test
    void withdraw_should_throw_exception_for_negative_amount() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-100));
    }

    @Test
    void printStatement_should_not_throw() {
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        // On vérifie juste que ça n'exceptionne pas
        assertDoesNotThrow(() -> account.printStatement());
    }
}
