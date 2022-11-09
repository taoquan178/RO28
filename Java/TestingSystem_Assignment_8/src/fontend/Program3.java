package fontend;

import java.util.Scanner;

import static backend.exercise3.Question1.genericClass;

public class Program3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("=============================");
            System.out.println("1: Question 1");
            System.out.println("0: Thoát");
            System.out.println("=============================");
            System.out.print("Mời bạn chọn: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 0:
                    return;
                case 1:
                    genericClass();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
            }
        }
    }
}
