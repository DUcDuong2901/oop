public class NickleAndDimeAccount extends Account {
    private static final double WITHDRAWAL_FEE = 0.5;
    private double initialBalance;
    private int withdrawCount = 0;
    public NickleAndDimeAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {

        balance -= amount;

        transactionCount++;
        withdrawCount++;
    }

    @Override
    public void endMonth() {
        double endOfMonthCharge = withdrawCount * WITHDRAWAL_FEE;
        balance -= endOfMonthCharge;

        //System.out.println("Total deposits: $" + (balance - initialBalance));
        //System.out.println("Total withdrawals: $" + (initialBalance - balance));

        System.out.println("Ending balance: $" + balance);
        super.endMonth();
    }
}
