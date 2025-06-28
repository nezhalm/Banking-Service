
package com.banking;
import com.banking.entity.Account;
import com.banking.service.AccountService;

public class Main {
    public static void main(String[] args) {
        AccountService account = new Account();
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        account.printStatement();
    }
}
