import java.util.Random;

public abstract class Account {

    protected double balance;
    protected int transactionCount;

    public Account(double initialBalance) {
        balance = initialBalance;
        transactionCount = 0;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionCount++;
    }

    public abstract void withdraw(double amount);

    public void endMonth() {
        transactionCount = 0;
    }
    public double getBalance() {
        return balance;
    }
}


