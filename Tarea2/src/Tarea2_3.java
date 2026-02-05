import java.util.Scanner;

public class Tarea2_3 {


    public static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Aspect Ratio Calculator ---");

        try {
            System.out.print("Enter the width (pixels): ");
            int width = scanner.nextInt();

            System.out.print("Enter the height (pixels): ");
            int height = scanner.nextInt();

            if (width <= 0 || height <= 0) {
                System.out.println("Error: Dimensions must be greater than zero.");
            } else {
                int gcd = getGCD(width, height);

                int ratioW = width / gcd;
                int ratioH = height / gcd;

                System.out.println("\nThe Aspect Ratio is " + ratioW + ":" + ratioH);

                double decimalRatio = (double) width / height;
                System.out.printf("Decimal aspect ratio: %.2f:1\n", decimalRatio);
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter integer numbers.");
        } finally {
            scanner.close();
        }
    }
}