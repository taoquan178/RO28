package fontend;

import backend.exercise1.Question1;
import java.util.List;
import java.util.Scanner;

import static backend.exercise1.Question2.StackAndQueue;
import static backend.exercise1.Question3.Question3;
import static backend.exercise1.Question4.Question4;
import static backend.exercise1.Question5.Question5;
import static backend.exercise1.Question6AndQuestion7.Map;

public class Program1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("=============================");
            System.out.println("1: Question 1");
            System.out.println("0: Thoát");
            System.out.println("=============================");
            System.out.println("Mời bạn chọn: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 0:
                    return;
                case 1:
                    Question1.List();
                    break;
                case 2:
                    StackAndQueue();
                    break;
                case 3:
                    Question3();
                    break;
                case 4:
                    Question4();
                    break;
                case 5:
                    Question5();
                    break;
                case 6:
                    Map();
                    break;
                case 7:
                    Map();
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
            }
        }
    }
}
