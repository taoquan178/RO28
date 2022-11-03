package BackEnd;
import Entity.*;

import java.util.Scanner;

public class Exercise_2_Polymorphism_Q1 {
    public static void Question1(){
        Student_EX2 student = new Student_EX2();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("===========================================================");
            System.out.println("1: Thêm mới học sinh");
            System.out.println("2: Gọi cả lớp điểm danh");
            System.out.println("3: Gọi 1 nhóm đi học bài");
            System.out.println("4: Gọi 1 nhóm đi dọn vệ sinh");
            System.out.println("0: Thoát chương trình");
            System.out.println("===========================================================");
            System.out.print("Mời bạn nhập lựa chọn: ");
            int choice = scanner.nextInt();
            switch(choice){
                case 0:
                    return;
                case 1:
                    System.out.print("Nhập số lượng Student muốn thêm vào: ");
                    int amountStudent = scanner.nextInt();
                    for (int i = 1; i<= amountStudent; i++){
                        System.out.println("===================================");
                        System.out.print("Nhập tên Student: ");
                        String nameStudent = scanner.next();
                        System.out.print("Chọn Group 1 or Group 2 or Group 3: ");
                        int groupStudent = scanner.nextInt();
                        switch (groupStudent){
                            case 1:
                                groupStudent = 1;
                                break;
                            case 2:
                                groupStudent = 2;
                                break;
                            case 3:
                                groupStudent = 3;
                                break;
                            default:
                                System.out.println("Chỉ chọn 1 or 2 or 3");
                        }
                        student.addStudent_Ex2(nameStudent,groupStudent);
                    }
                    break;
                case 2:
                    student.DiemDanh();
                    break;
                case 3:
                    student.HocBai();
                    break;
                case 4:
                    student.DiDonVeSinh();
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");

            }
        }
    }
}
