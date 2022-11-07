package entity;

import java.util.Scanner;

public class ScannerUltis {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputInt(String errorMessage){
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                System.err.println(errorMessage);
            }
        }
    }

    public static float inputFloat(String errorMessage) {
        while (true) {
            try {
                return Float.parseFloat(scanner.nextLine().trim());
            } catch (Exception e) {
                System.err.println(errorMessage);
            }
        }
    }

    public static double inputDouble(String errorMessage) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (Exception e) {
                System.err.println(errorMessage);
            }
        }
    }

    public static String inputString(String errorMessage) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.err.println(errorMessage);
            }
        }
    }

}
