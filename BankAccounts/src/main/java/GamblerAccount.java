import java.util.Random;

public class GamblerAccount extends Account {


    private Random random = new Random();
    public Random getRandom() {
        return random;
    }
    private double initialBalance;

    public GamblerAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (random.nextDouble() <= 0.5) {
            balance -= amount;
        } else {
            balance -= 2.0 * amount;
        }
        transactionCount++;
    }

    @Override
    public void endMonth() {



        System.out.println("Ending balance: $" + balance);
        super.endMonth();
    }
}
