import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.awt.Point;


/*
 Shape data for ShapeClient:
 "0 0  0 1  1 1  1 0"
 "10 10  10 11  11 11  11 10"
 "0.5 0.5  0.5 -10  1.5 0"
 "0.5 0.5  0.75 0.75  0.75 0.2"
*/
public class Shape {
    private List<Point> vertices;
    private Point center;
    private double radius;
    private Point[] points;

    public Shape(String input) {
        Scanner scanner = new Scanner(input);
        vertices = new ArrayList<>();

        while (scanner.hasNextDouble()) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            vertices.add(new Point((int) x, (int) y));
        }

        scanner.close();
        computeCircle();
    }

    public Shape(Point[] points) {
        this.points = points;
        this.vertices = new ArrayList<>();
        for (Point point : points) {
            this.vertices.add(point);
        }
    }






    public boolean crosses(Shape other) {
        for (int i = 0; i < vertices.size(); i++) {
            Point v1 = vertices.get(i);
            Point v2 = vertices.get((i + 1) % vertices.size());

            if (other.contains(v1) && !other.contains(v2)) {
                return true;
            }
        }

        return false;
    }

    public int encircles(Shape other) {
        if (contains(other.center)) {
            return 2;
        } else if (intersects(other)) {
            return 1;
        } else {
            return 0;
        }
    }

    private void computeCircle() {
        double centerX = 0;
        double centerY = 0;

        for (Point v : vertices) {
            centerX += v.getX();
            centerY += v.getY();
        }

        centerX /= vertices.size();
        centerY /= vertices.size();
        center = new Point((int)centerX, (int) centerY);

        double maxDistance = 0;

        for (Point v : vertices) {
            double distance = v.distance(center);

            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }

        radius = maxDistance;
    }

    private boolean contains(Point point) {
        return point.distance(center) <= radius;
    }

    private boolean intersects(Shape other) {
        double distance = center.distance(other.center);

        if (distance > radius + other.radius) {
            return false;
        }

        if (distance < Math.abs(radius - other.radius)) {
            return false;
        }

        return true;
    }




}



