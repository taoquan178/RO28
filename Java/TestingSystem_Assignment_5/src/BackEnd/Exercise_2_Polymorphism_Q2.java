package BackEnd;
import Entity.*;

import java.util.Scanner;

public class Exercise_2_Polymorphism_Q2 {
    public static void Question2(){
        Person person = new Person();
        Student_EX2_Q2 student_ex2_q2= new Student_EX2_Q2();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("===========================================================");
            System.out.println("1: Nhập thông tin Student: ");
            System.out.println("2: Hiển thị thông tin Student: ");
            System.out.println("3: Kiểm tra Student xem có được học bổng không? ");
            System.out.println("0: Thoát chương trình");
            System.out.println("===========================================================");
            System.out.print("Mời bạn nhập lựa chọn: ");
            int choice = scanner.nextInt();
            switch(choice){
                case 0:
                    return;
                case 1:
                    student_ex2_q2.inputInfo();
                    break;
                case 2:
                    student_ex2_q2.showInfo();
                    break;
                case 3:
                    student_ex2_q2.Scholarship();
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
            }
        }
    }
}
