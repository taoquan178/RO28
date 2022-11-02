package BackEnd;

import Entity.*;

import java.util.Scanner;

public class Exercise_1_Abstraction_Q1_MyNews {
    public static void Menu1() {
        Scanner scanner = new Scanner(System.in);
        News newss = new News();
        while(true){
            System.out.println("=================");
            System.out.println("1: Insert news");
            System.out.println("2: View list news");
            System.out.println("3: Average rate");
            System.out.println("0: Exit");
            System.out.println("=================");
            System.out.print("Mời bạn nhập lựa chọn: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 0:
                    return;
                case 1:
                    System.out.print("Nhập title: ");
                    String title = scanner.next();
                    System.out.print("Nhập publishDate: ");
                    String publishDate = scanner.next();
                    System.out.print("Nhập author: ");
                    String author = scanner.next();
                    System.out.print("Nhập content: ");
                    String content = scanner.next();

                    System.out.println("Nhập vào đánh giá 1");
                    float rate1 = scanner.nextInt();
                    System.out.println("Nhập vào đánh giá 2");
                    float rate2 = scanner.nextInt();
                    System.out.println("Nhập vào đánh giá 3");
                    float rate3 = scanner.nextInt();
                    float[] rates = { rate1, rate2, rate3 };

                    newss.InsertNews(title,publishDate,author,content, rates);

                    break;
                case 2:
                    newss.Display();
                    break;
                case 3:
                    newss.AverageRate();
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
            }
        }
    }

}
