package fontend;

import backend.exercise3.*;
import backend.exercise4.*;
import entity.StudentEx1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program4 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        IOManager ex4 = new IOManager();
        StudentEx1 studentEx1 = new StudentEx1();
        ArrayList<StudentEx1> studentEx1List = new ArrayList<StudentEx1>();
        while (true){
            System.out.println("================================");
            System.out.print("Mời bạn nhập lựa chọn: ");
            System.out.println("1: Tạo method read File");
            System.out.println("2: Tạo method write content to File");
            System.out.println("3: Tạo method write Object");
            System.out.println("4: Tạo method read Object");
            System.out.println("0: Thoát chương trình");
            System.out.println("================================");
            System.out.println("Mời bạn nhập lựa chọn");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    return;
                case 1:
//                    C:/Users/Trung Quan/Desktop/file1.txt
                    System.out.println("Nhập vào đường dẫn file: ");
                    String pathFile = CheckFile.CheckisFile();
                    ex4.readFile(pathFile);
                    break;
                case 2:
                    System.out.println("Nhập vào đường dẫn file: ");
                    String pathFile1 = CheckFile.CheckisFile();
                    System.out.println("1: chọn ghi tiếp - 2: chọn gi đè");
                    int choice1 = scanner.nextInt();
                    boolean isboolean = true;
                    switch (choice1){
                        case 1:
                             isboolean = true;
                            break;
                        case 2:
                             isboolean = false;
                             break;
                        default:
                            System.out.println("bạn chỉ được chọn 1 hoặc 2");
                    }
                    System.out.println("Nhập nội dung muốn ghi: ");
                    scanner.nextLine();
                    String content = scanner.nextLine();
                    ex4.writeFile(pathFile1,isboolean,content);
                    break;
                case 3:
                    System.out.print("Nhập tên Sudent muốn thêm: ");
                    String nameStudent = scanner.next();
                    StudentEx1 studentEx11 = new StudentEx1(nameStudent);
                    studentEx1List.add(studentEx11);
                    System.out.println("Nhập vào đường dẫn file: ");
                    System.out.println("định dạng: C:/Users/Trung Quan/Desktop/new111");
                    scanner.nextLine();
                    String pathFile3 = scanner.nextLine();
                    System.out.println("Nhập vào tên file: ");
                    String fileName3 = scanner.next();
                    ex4.writeObject(studentEx11,pathFile3,fileName3);
                    break;
                case 4:

                    System.out.print("Nhập tên Sudent muốn thêm: ");
                    String nameStudent2 = scanner.next();
                    StudentEx1 studentEx12 = new StudentEx1(nameStudent2);
                    studentEx1List.add(studentEx12);
                    System.out.println("Nhập vào đường dẫn file: ");
                    System.out.println("định dạng: C:/Users/Trung Quan/Desktop/new111/quan.txt");
                    String pathFile4 = CheckFile.CheckisFile();
                    ex4.readObject(studentEx12,pathFile4);
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
            }
        }
    }
}
