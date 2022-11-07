package fontend;

import backend.exercise3.*;

import java.util.Scanner;

import static backend.exercise2.Question2.Question2;


public class Program3 {
//    public static final String PATH = "C:\\Users\\Trung Quan\\Desktop\\text1.txt";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("================================");
            System.out.print("Mời bạn nhập lựa chọn: ");
            System.out.println("1: Check File is exists");
            System.out.println("2: Create new file");
            System.out.println("3: Dề không có Question 3");
            System.out.println("4: Delete file");
            System.out.println("5: Check path is File or Folder");
            System.out.println("6: Get all File name of Folder");
            System.out.println("7: Copy file");
            System.out.println("8: Moving file");
            System.out.println("9: Rename File");
            System.out.println("10:Create new folder");
            System.out.println("11:Download File");
            System.out.println("0: Thoát chương trình");
            System.out.println("================================");
            System.out.println("Mời bạn nhập lựa chọn");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    scanner.nextLine();
                    System.out.println("Mời bạn nhập vào đường dẫn file theo định dạng: ");
                    System.out.println("C:/Users/Trung Quan/Desktop/file1.txt");
                    Question1 q1 = new Question1();
                    String PATH = scanner.nextLine();
                    q1.Question1(PATH);
                    break;
                case 2:
                    Question2 q2 = new Question2();
                    scanner.nextLine();
                    System.out.println("Mời bạn nhập vào đường dẫn file theo định dạng: ");
                    System.out.println("C:/Users/Trung Quan/Desktop");
                    String PATHQ2 = scanner.nextLine();
                    System.out.println("Nhập vào tên file cần tạo");
                    String fileName = scanner.next();
                    q2.Question2(PATHQ2,fileName);
                    break;
                case 3:
                    Question3 q3 = new Question3();
                    q3.Question3();
                    break;
                case 4:
                    Question4 q4 = new Question4();
                    scanner.nextLine();
                    System.out.println("Mời bạn nhập vào đường dẫn file cần xoá theo định dạng: ");
                    System.out.println("C:/Users/Trung Quan/Desktop/file1.txt");
                    String PATHQ4 = scanner.nextLine();
                    q4.Question4(PATHQ4);
                    break;
                case 5:
                    Question5 q5 = new Question5();
                    scanner.nextLine();
                    System.out.println("Mời bạn nhập vào đường dẫn file or folder theo định dạng: ");
                    System.out.println("C:/Users/Trung Quan/Desktop/file1.txt");
                    System.out.println("C:/Users/Trung Quan/Desktop");
                    String PATHQ5 = scanner.nextLine();
                    q5.Question5(PATHQ5);
                    break;
                case 6:
                    Question6 q6 = new Question6();
                    scanner.nextLine();
                    System.out.println("Mời bạn nhập vào đường dẫn folder cần in tên theo định dạng: ");
                    System.out.println("C:/Users/Trung Quan/Desktop");
                    String PATHQ6 = scanner.nextLine();
                    q6.Question6(PATHQ6);
                    break;
                case 7:
                    Question7 q7 = new Question7();
                    q7.Question7();
                    break;
                case 8:
                    Question8 q8 = new Question8();
                    q8.Question8();
                    break;
                case 9:
                    Question9 q9 = new Question9();
                    q9.Question9();
                    break;
                case 10:
                    Question10 q10 = new Question10();
                    q10.Question10();
                    break;
                case 11:
                    Question11 q11 = new Question11();
                    q11.Question11();
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
            }
        }

    }
}
