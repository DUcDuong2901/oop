import java.util.Arrays;
import java.util.Scanner;

public class ShapeClient {
    public static void main(String[] args) {
        Shape a = createShapeFromString("0 0 0 1 1 1 1 0");
        Shape b = createShapeFromString("10 10 10 11 11 11 11 10");
        Shape c = createShapeFromString("0.5 0.5 0.5 -10 1.5 0");
        Shape d = createShapeFromString("0.5 0.5 0.75 0.75 0.75 0.2");

        // compare shape a with the other three shapes and print the result
        System.out.println("a crosses b: " + a.crosses(b));
        System.out.println("a crosses c: " + a.crosses(c));
        System.out.println("a crosses d: " + a.crosses(d));
        System.out.println("a encircles b: " + a.encircles(b));
        System.out.println("a encircles c: " + a.encircles(c));
        System.out.println("a encircles d: " + a.encircles(d));
    }

    // helper function to create a Shape object from a string
    public static Shape createShapeFromString(String input) {
        Scanner scanner = new Scanner(input);
        int numPoints = input.split(" ").length / 2; // each point has two coordinates
        Point[] points = new Point[numPoints];
        for (int i = 0; i < numPoints; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points[i] = new Point(x, y);
        }
        return  new Shape(Arrays.toString(points));
    }

}