public abstract class FeeAccount extends Account {
    private static final double FEE_AMOUNT = 5.0;
    private double initialBalance;

    public FeeAccount(double initialBalance) {
        super(initialBalance);
        this.initialBalance = initialBalance;
    }

    @Override
    public void endMonth() {
        balance -= FEE_AMOUNT;

        //System.out.println("Total deposits: $" + (balance - initialBalance));
        //System.out.println("Total withdrawals: $" + (initialBalance - balance));
        System.out.println("Ending balance: $" + (balance));
        super.endMonth();
    }
}
