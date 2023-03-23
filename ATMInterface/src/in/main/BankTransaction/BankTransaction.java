package in.main.BankTransaction;

import java.util.Date;

public class BankTransaction {
    private String transactionType;
    private double amount;
    private Date timestamp;
    private String sourceAccountNumber;
    private String destinationAccountNumber;

    public BankTransaction(String transactionType, String sourceAccountNumber, String destinationAccountNumber, double amount) {
        this.transactionType = transactionType;
        this.sourceAccountNumber = sourceAccountNumber;
        this.destinationAccountNumber = destinationAccountNumber;
        this.amount = amount;
        this.timestamp = new Date();
    }

    public String getTransactionType() {
        return this.transactionType;
    }

    public double getAmount() {
        return this.amount;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }
    
    public String getSourceAccountNumber() {
        return this.sourceAccountNumber;
    }

    public void setSourceAccountNumber(String sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
    }

    public String getDestinationAccountNumber() {
        return this.destinationAccountNumber;
    }

    public void setDestinationAccountNumber(String destinationAccountNumber) {
        this.destinationAccountNumber = destinationAccountNumber;
    }
}
