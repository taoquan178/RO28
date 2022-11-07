package fontend;
import backend.exercise1.*;

import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) throws Exception {
        Question1 q1 = new Question1();
        Question2 q2 = new Question2();
        Question3 q3 = new Question3();
        Question4 q4 = new Question4();
        Question5 q5 = new Question5();
        Question6 q6 = new Question6();
        Question7 q7 = new Question7();
        Question8 q8 = new Question8();
        Question9 q9 = new Question9();

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("=============");
            System.out.println("Execrcise 1");
            System.out.println("1:Question 1");
            System.out.println("2:Question 2");
            System.out.println("3:Question 3");
            System.out.println("4:Question 4");
            System.out.println("5:Question 5");
            System.out.println("6:Question 6");
            System.out.println("7:Question 7");
            System.out.println("8:Question 8");
            System.out.println("9:Question 9");
            System.out.println("0:Thoát");
            System.out.println("==============");
            System.out.print("Mời bạn nhập lựa chọn: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    System.out.println("Question 1");
                    q1.Question1();
                    break;
                case 2:
                    System.out.println("Question 2");
                    q2.Question2();
                    break;
                case 3:
                    System.out.println("Question 3");
                    q3.Question3();
                    break;
                case 4:
                    System.out.println("Question 4");
                    q4.Question4();
                    break;
                case 5:
                    System.out.println("Question 5");
                    q5.Question5();
                    break;
                case 6:
                    System.out.println("Question 6");
                    q6.Question6();
                    break;
                case 7:
                    System.out.println("Question 7");
                    q7.Question7();
                    break;
                case 8:
                    System.out.println("Question 8");
                    q8.Question8();
                    break;
                case 9:
                    System.out.println("Question 9");
                    q9.Question9();
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
            }
        }
//        System.out.println("Question 1");
//        q1.Question1();
//        System.out.println("Question 2");
//        q2.Question2();
//        System.out.println("Question 3");
//        q3.Question3();
//        System.out.println("Question 4");
//        q4.Question4();
//        System.out.println("Question 5");
//        q5.Question5();
//        System.out.println("Question 6");
//        q6.Question6();
//        System.out.println("Question 7");
//        q7.Question7();
//        System.out.println("Question 8");
//        q8.Question8();
//        System.out.println("Question 9");
//        q9.Question9();
    }
}
