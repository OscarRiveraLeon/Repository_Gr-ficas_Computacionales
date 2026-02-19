package images;

import java.util.Scanner;

public class Tarea2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Choose conversion:");
        System.out.println("1. Polar to Cartesian");
        System.out.println("2. Cartesian to Polar");
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.print("Enter r: ");
            double r = input.nextDouble();
            System.out.print("Enter angle (degrees): ");
            double angle = input.nextDouble();
            double radians = Math.toRadians(angle);

            double x = r * Math.cos(radians);
            double y = r * Math.sin(radians);

            System.out.println("Cartesian: (x: " + x + ", y: " + y + ")");
        } else if (choice == 2) {
            System.out.print("Enter x: ");
            double x = input.nextDouble();
            System.out.print("Enter y: ");
            double y = input.nextDouble();

            double r = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            double angle = Math.toDegrees(Math.atan2(y, x));

            System.out.println("Polar: (r: " + r + ", angle: " + angle + "°)");
        }
        input.close();
    }
}