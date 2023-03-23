package in.main.Account;

import java.util.*;

import in.main.Bank.Bank;
import in.main.BankTransaction.BankTransaction;

public class Account {
    private String accountNumber;
    private double balance;
    private List<BankTransaction> transactionHistory;
    private Bank bank;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
        BankTransaction transaction = new BankTransaction("deposit", "", "", amount);
        this.transactionHistory.add(transaction);
    }

    public boolean withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            BankTransaction transaction = new BankTransaction("withdraw", "", "", amount);
            this.transactionHistory.add(transaction);
            return true;
        }
        return false;
    }


    public boolean transfer(Account destinationAccount, double amount) {
        if (this.balance >= amount && destinationAccount != null && !this.accountNumber.equals(destinationAccount.getAccountNumber())) {
            this.balance -= amount;
            BankTransaction transaction = new BankTransaction("transfer", this.accountNumber, destinationAccount.getAccountNumber(), amount);
            this.transactionHistory.add(transaction);
            destinationAccount.deposit(amount);
            return true;
        }
        return false;
    }


    public List<BankTransaction> getTransactionHistory() {
        List<BankTransaction> accountTransactions = new ArrayList<BankTransaction>();
        for (BankTransaction transaction : bank.getTransactionHistory(this.accountNumber)) {
            if (transaction.getTransactionType().equals("withdraw") || transaction.getTransactionType().equals("deposit")) {
                accountTransactions.add(transaction);
            }
        }
        return accountTransactions;
    }
}
