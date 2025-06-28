package com.banking.entity;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.banking.service.AccountService;

public class Account implements AccountService {

    private final List<Transaction> transactions = new ArrayList<>();

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        transactions.add(new Transaction(currentDate(), amount));
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }

        int balance = getCurrentBalance();
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        transactions.add(new Transaction(currentDate(), -amount));
    }

    @Override
    public void printStatement() {
    System.out.println("Date      || Amount || Balancegit ");
    int balance = getCurrentBalance();

    for (int i = transactions.size() - 1; i >= 0; i--) {
        Transaction transaction = transactions.get(i);
        System.out.printf("%s | %d | %d%n", transaction.getDate(), transaction.getAmount(), balance);
        balance -= transaction.getAmount();
    }
}


    private LocalDate currentDate() {
        return LocalDate.now();
    }

    private int getCurrentBalance() {
        return transactions.stream().mapToInt(Transaction::getAmount).sum();
    }
}
