package Main;

import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Get an integer input
    public static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) { // Validate integer input
            System.out.println("Invalid input: Please enter a valid number.");
            System.out.print(prompt);
            scanner.next(); // Clear invalid input
        }
        return scanner.nextInt();
    }

    // Close the scanner
    public static void closeScanner() {
        scanner.close();
    }
}