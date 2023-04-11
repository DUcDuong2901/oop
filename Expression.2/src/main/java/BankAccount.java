// BankAccount.java
public class BankAccount {
    private int accountNumber;
    private String ownerName;
    private double balance;
    private int transactionCount;

    public BankAccount(int accountNumber, String ownerName, double balance, int transactionCount) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        this.transactionCount = transactionCount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }
}

