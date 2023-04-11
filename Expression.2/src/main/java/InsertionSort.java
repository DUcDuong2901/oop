// InsertionSort.java
public class InsertionSort {
    public void sort(BankAccount[] account, MyComparator compare) {
        int n = account.length;
        for (int i = 1; i < n; ++i) {
            BankAccount key = account[i];
            int j = i - 1;

            while (j >= 0 && compare.less(key, account[j])) {
                account[j + 1] = account[j];
                j = j - 1;
            }
            account[j + 1] = key;
        }
    }
}
