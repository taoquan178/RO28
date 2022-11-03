package Entity;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScannerUtils {
    public static void inputInt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào errorMessage");
        String errorMessage = scanner.next();
        try {
        System.out.println("Nhập vào dữ liệu số; ");
        int duLieuSo = scanner.nextInt();
        }catch (NoSuchElementException e){
            System.out.println(errorMessage);
        }


        


    }
}
