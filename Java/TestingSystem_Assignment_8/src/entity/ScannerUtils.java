package entity;

import java.util.Scanner;

public class ScannerUtils {
    private static Scanner scanner = new Scanner(System.in);
    public static int InputInt(String errorMessage){
        while (true){
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            }catch ( Exception e){
                System.err.println(errorMessage);
            }
        }
    }

    public static String InputString(String errorMessage){
        while (true){
            String inputString = scanner.nextLine().trim();
            if (!inputString.isEmpty()){
                return inputString;
            }else {
                System.out.println(errorMessage);
            }
        }
    }


}
