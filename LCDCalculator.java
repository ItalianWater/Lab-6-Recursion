import java.util.Scanner;

public class LCDCalculator {

    // Recursive method to find the greatest common divisor (GCD)
    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    // Method to find the least common multiple (LCM)
    public static int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }

    // Recursive method to calculate least common denominator (LCD) and reduce fractions to lowest terms
    public static int[] calculateLCD(int numerator1, int denominator1, int numerator2, int denominator2) {
        if (numerator1 == 0 || numerator2 == 0) {
            return new int[]{0, 0, 0}; // Return 0 if any numerator is 0
        }

        // Calculate least common multiple of denominators
        int leastCommonDenominator = findLCM(denominator1, denominator2);

        // Convert numerators based on the common denominator
        int convertedNum1 = numerator1 * (leastCommonDenominator / denominator1);
        int convertedNum2 = numerator2 * (leastCommonDenominator / denominator2);

        // Find the greatest common divisor of the two numerators
        int commonDivisor = findGCD(convertedNum1, convertedNum2);

        // Reduce to lowest terms
        convertedNum1 /= commonDivisor;
        convertedNum2 /= commonDivisor;

        return new int[]{leastCommonDenominator, convertedNum1, convertedNum2};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter numerator of first fraction: ");
        int numerator1 = scanner.nextInt();
        System.out.print("Enter denominator of first fraction: ");
        int denominator1 = scanner.nextInt();
        System.out.print("Enter numerator of second fraction: ");
        int numerator2 = scanner.nextInt();
        System.out.print("Enter denominator of second fraction: ");
        int denominator2 = scanner.nextInt();

        int[] result = calculateLCD(numerator1, denominator1, numerator2, denominator2);
        int lcd = result[0];
        int reducedNum1 = result[1];
        int reducedNum2 = result[2];

        System.out.println("The least common denominator of " + numerator1 + "/" + denominator1 +
                " and " + numerator2 + "/" + denominator2 + " is: " + lcd);
        System.out.println("The fractions in the same denominator are: " + reducedNum1 + "/" + lcd +
                " and " + reducedNum2 + "/" + lcd);
    }
}
