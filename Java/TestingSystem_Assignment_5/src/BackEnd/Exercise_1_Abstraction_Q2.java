package BackEnd;

import Entity.*;

import java.util.Scanner;

public class Exercise_1_Abstraction_Q2 {
    public static void Menu() {
        TuyenSinh tuyenSinh = new TuyenSinh();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("===========================================================");
            System.out.println("1: Thêm mới thí sinh");
            System.out.println("2: Hiện thị thông tin của thí sinh và khối thi của thí sinh");
            System.out.println("3: Tìm kiếm theo số báo danh");
            System.out.println("4: Thoát khỏi chương trình");
            System.out.println("===========================================================");
            System.out.print("Mời bạn nhập lựa chọn: ");
            int chon = scanner.nextInt();
            switch(chon){
                case 1:
                    // String name, String homeTown, int priority,String clazzName
                    System.out.println("Nhập tên Student: ");
                    String tenStudent = scanner.next();
                    System.out.println("Nhập địa chỉ: ");
                    String homeTown = scanner.next();
                    System.out.println("Nhập vào priority: ");
                    int priority = scanner.nextInt();
                    System.out.println("Nhập khối A or B or C: ");
                    String clazzName = scanner.next();
                    tuyenSinh.AddStudent(tenStudent,homeTown,priority,clazzName);
                    break;
                case 2:
                    tuyenSinh.ShowStudentAndClazz();
                    break;
                case 3:
                    tuyenSinh.SearchStudent();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Mời bạn nhập lại");

            }
        }
    }
}
