package IPIJ;
import java.util.Scanner;
public class bai2_WindChill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double t = scanner.nextDouble();
        double v = scanner.nextDouble();
        double w = 35.74 + 0.6215*t + (0.4275*t - 35.75) * Math.pow(v, 0.16);
        System.out.println("Temperature = " + t);
        System.out.println("Wind speed  = " + v);
        System.out.println("Wind chill  = " + w);
    }
}
