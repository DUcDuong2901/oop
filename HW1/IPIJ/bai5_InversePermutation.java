package IPIJ;

public class bai5_InversePermutation {
    public static void main(String[] args) {

        int n = args.length;


        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(args[i]);


        boolean[] exists = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (a[i] < 0 || a[i] >= n || exists[a[i]])
                throw new RuntimeException("Input is not a permutation.");
            exists[a[i]] = true;
        }


        int[] ainv = new int[n];
        for (int i = 0; i < n; i++) {
            ainv[a[i]] = i;
        }



        for (int i = 0; i < n; i++) {
            System.out.print(ainv[i] + " ");
        }
        System.out.println();
    }
}
