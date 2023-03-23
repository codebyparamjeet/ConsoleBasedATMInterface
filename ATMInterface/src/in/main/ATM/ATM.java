package in.main.ATM;

import java.util.List;
import java.util.Scanner;

import in.main.Account.Account;
import in.main.AccountHolder.AccountHolder;
import in.main.Bank.Bank;
import in.main.BankTransaction.BankTransaction;

public class ATM {
    private Bank bank;
    private AccountHolder accountHolder;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user id: ");
        String userId = scanner.next();
        System.out.print("Enter user pin: ");
        String userPin = scanner.next();
        this.accountHolder = new AccountHolder(userId, userPin);

        // check if user id and pin are valid
        boolean isValidUser = false;
        for (Account account : bank.accounts) {
        	if (accountHolder.getUserId().equals(userId) && accountHolder.getUserPin().equals(userPin))
        		{
                 isValidUser = true;
                 break;
             }
         }

         if (!isValidUser) {
             System.out.println("Invalid user id or pin.");
             return;
         }

         // display account information and options
         Account account = null;
         while (account == null) {
             System.out.print("Enter account number: ");
             String accountNumber = scanner.next();
             account = bank.getAccountByNumber(accountNumber);
             if (account == null) {
                 System.out.println("Invalid account number.");
             }
         }

         System.out.println("Account balance: " + account.getBalance());

         boolean continueTransaction = true;
         while (continueTransaction) {
             System.out.println("1. Deposit");
             System.out.println("2. Withdraw");
             System.out.println("3. Transfer");
             System.out.println("4. Transaction History");
             System.out.println("5. Exit");
             System.out.println("6. Check Balance");
             System.out.print("Enter option number: ");
             int option = scanner.nextInt();

             switch (option) {
             case 1:
            	    System.out.print("Enter amount to deposit: ");
            	    double depositAmount = scanner.nextDouble();
            	    account.deposit(depositAmount);
            	    bank.addTransaction(new BankTransaction("deposit", account.getAccountNumber(), null, depositAmount));
            	    System.out.println("Deposit successful.");
            	    break;
            	case 2:
            	    System.out.print("Enter amount to withdraw: ");
            	    double withdrawAmount = scanner.nextDouble();
            	    boolean withdrawSuccess = account.withdraw(withdrawAmount);
            	    if (withdrawSuccess) {
            	        bank.addTransaction(new BankTransaction("withdraw", account.getAccountNumber(), null, withdrawAmount));
            	        System.out.println("Withdrawal successful.");
            	    } else {
            	        System.out.println("Insufficient balance.");
            	    }
            	    break;
                 case 3:
                	    System.out.print("Enter destination account number: ");
                	    String destinationAccountNumber = scanner.next();
                	    Account destinationAccount = bank.getAccountByNumber(destinationAccountNumber);
                	    if (destinationAccount == null) {
                	        System.out.println("Invalid destination account number.");
                	        break;
                	    }
                	    System.out.print("Enter transfer amount: ");
                	    double transferAmount = scanner.nextDouble();
                	    boolean transferSuccess = account.transfer(destinationAccount, transferAmount);
                	    if (transferSuccess) {
                	        bank.addTransaction(new BankTransaction("transfer", account.getAccountNumber(), destinationAccountNumber, transferAmount));
                	        System.out.println("Transfer successful.");
                	    } else {
                	        System.out.println("Insufficient balance.");
                	    }
                	    break;
                 case 4:
                	    if (account != null) {
                	        List<BankTransaction> transactionHistory = bank.getTransactionHistory(account.getAccountNumber());
                	        for (BankTransaction transaction : transactionHistory) {
                	            System.out.println(transaction.getTransactionType() + " " + transaction.getAmount() + " " + transaction.getTimestamp());
                	        }
                	    } else {
                	        System.out.println("Invalid account.");
                	    }
                	    break;
                 case 5:
                     continueTransaction = false;
                     break;
                 case 6:
                	 System.out.println("Account balance: " + account.getBalance());
                	    break;
                 default:
                     System.out.println("Invalid option.");
             }
         }
 }
        }
