package P05_Intersection_Of_Circles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Circle c1 = ReadCircle(reader.readLine());
        Circle c2 = ReadCircle(reader.readLine());
        // distance between the circle centers
        double d = CalcDistance(c1.getCenter(), c2.getCenter());

        if (d > (c1.getRadius() + c2.getRadius())) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
    private static Circle ReadCircle(String inputLine) {
        double[] input = Arrays
                .stream(inputLine.split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Point p = new Point(input[0], input[1]);
        Circle c = new Circle(p, input[2]);
        return c;
    }

    private static double CalcDistance(Point p1, Point p2) {
        double sideA = Math.abs(Math.abs(p1.getX()) - Math.abs(p2.getX()));
        double sideB = Math.abs(Math.abs(p1.getY()) - Math.abs(p2.getY()));
        double distance = Math.sqrt(sideA * sideA + sideB * sideB);

        return distance;
    }
}
