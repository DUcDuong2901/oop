// SortDemo.java
// SortDemo.java
public class SortDemo {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[5];
        accounts[0] = new BankAccount(1, "Alice", 1000, 5);
        accounts[1] = new BankAccount(2, "Bob", 500, 10);
        accounts[2] = new BankAccount(3, "Charlie", 3000, 1);
        accounts[3] = new BankAccount(4, "Dave", 200, 15);
        accounts[4] = new BankAccount(5, "Eve", 4000, 3);

        MyComparator balanceAscending = new BalanceAscending();
        MyComparator balanceDescending = new BalanceDescending();
        MyComparator transactionCountDescending = new TransactionCountDescending();

        InsertionSort sorter = new InsertionSort();

        System.out.println("Before sorting:");
        printAccounts(accounts);

        sorter.sort(accounts, balanceAscending);
        System.out.println("After sorting by balance in ascending order:");
        printAccounts(accounts);

        sorter.sort(accounts, balanceDescending);
        System.out.println("After sorting by balance in descending order:");
        printAccounts(accounts);

        sorter.sort(accounts, transactionCountDescending);
        System.out.println("After sorting by transaction count in descending order:");
        printAccounts(accounts);
    }

    private static void printAccounts(BankAccount[] accounts) {
        for (BankAccount account : accounts) {
            System.out.println(account.getOwnerName() + " has balance " + account.getBalance() + " and " + account.getTransactionCount() + " transactions.");
        }
        System.out.println();
    }
}
