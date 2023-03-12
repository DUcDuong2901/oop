package BaitapB;

public class bai4_FunctionGrowth{
    public static void main(String[] args) {
        System.out.println("log n \t\tn \t\t   nlogn \t\tn^2 \t\tn^3");
        for (long i = 2; i <= 2048; i *= 2) {
            System.out.print((int) Math.log(i));
            System.out.print('\t');
            System.out.print('\t');
            System.out.print('\t');
            System.out.print(i);
            System.out.print('\t');
            System.out.print('\t');
            System.out.print('\t');
            System.out.print((int) (i * Math.log(i)));
            System.out.print('\t');
            System.out.print('\t');
            System.out.print('\t');
            System.out.print(i * i);
            System.out.print('\t');
            System.out.print('\t');
            System.out.print('\t');
            System.out.print(i * i * i);
            System.out.println();
        }
    }
}
