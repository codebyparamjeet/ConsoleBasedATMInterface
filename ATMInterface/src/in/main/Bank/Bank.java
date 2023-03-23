package in.main.Bank;

import java.util.ArrayList;
import java.util.List;

import in.main.Account.Account;
import in.main.BankTransaction.BankTransaction;

public class Bank {
    public List<Account> accounts;
    private List<BankTransaction> transactions;

    public Bank() {
        this.accounts = new ArrayList<Account>();
        this.transactions = new ArrayList<BankTransaction>();
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public Account getAccountByNumber(String accountNumber) {
        for (Account account : this.accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void addTransaction(BankTransaction transaction) {
        this.transactions.add(transaction);
    }

    public List<BankTransaction> getTransactionHistory(String accountNumber) {
        List<BankTransaction> accountTransactions = new ArrayList<BankTransaction>();
        Account account = getAccountByNumber(accountNumber);
        if (account != null) {
            for (BankTransaction transaction : this.transactions) {
                if (transaction.getSourceAccountNumber().equals(accountNumber) || 
                    transaction.getDestinationAccountNumber().equals(accountNumber)) {
                    accountTransactions.add(transaction);
                }
            }
        }
        return accountTransactions;
    }

}
