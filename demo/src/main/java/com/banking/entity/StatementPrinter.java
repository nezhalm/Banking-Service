package com.banking.entity;

import java.util.List;

public class StatementPrinter {

    public void print(List<Transaction> transactions) {
        System.out.println("DATE | AMOUNT | BALANCE");
        int balance = 0;

        for (int i = 0; i < transactions.size(); i++) {
            Transaction t = transactions.get(i);
            balance += t.getAmount();
            System.out.printf("%s | %d | %d%n", t.getDate(), t.getAmount(), balance);
        }
    }
}
