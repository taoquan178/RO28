package backend.exercise1;

import entity.PrimaryStudent;
import entity.SecondaryStudent;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Question7 {
    public void Question7(){
        Scanner scanner = new Scanner(System.in);
        PrimaryStudent primaryStudentList = new PrimaryStudent();
        SecondaryStudent secondaryStudentList = new SecondaryStudent();
        while (true){
            System.out.println("==================================================");
            System.out.println("1: Tạo PrimaryStudent");
            System.out.println("2: Tạo SecondaryStudent");
            System.out.println("3: Show PrimaryStudent và tổng số lượng Student");
            System.out.println("4: Show SecondaryStudent và tổng số lượng Student");
            System.out.println("5: Tổng số lượng Student đã thêm vào của cả 2");
            System.out.println("0: Thoát");
            System.out.println("==================================================");
            System.out.print("Mời bạn nhập lựa chọn: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    try {
                        System.out.print("Nhập số PrimaryStudent bạn muốn tạo, tối đa 7 Student: ");
                        int numPrimaryStudent = scanner.nextInt();
                        if (numPrimaryStudent <= 7 && numPrimaryStudent > 0 ){
                        }else {
                            System.out.println("Số lượng nhập chỉ được 7 người");
                            numPrimaryStudent = 7;
                        }
                        for (int i = 0; i < numPrimaryStudent; i++) {
                            System.out.print("Nhập tên PrimaryStudent: ");
                            String namePrimaryStudent = scanner.next();
                            primaryStudentList.addPrimaryStudent(namePrimaryStudent);
                        }
                    }catch (NoSuchElementException e){
                        System.out.println("Mời bạn nhập lại");
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Nhập số SecondaryStudent bạn muốn tạo, tối đa 7 Student: ");
                        int numSecondaryStudent = scanner.nextInt();
                        if (numSecondaryStudent <= 7 && numSecondaryStudent > 0 ){
                        }else {
                            System.out.println("Số lượng nhập chỉ được 7 người");
                            numSecondaryStudent = 7;
                        }
                        for (int i = 0; i < numSecondaryStudent; i++) {
                            System.out.print("Nhập tên SecondaryStudent: ");
                            String nameSecondaryStudent = scanner.next();
                            secondaryStudentList.addSecondaryStudent(nameSecondaryStudent);
                        }
                    }catch (NoSuchElementException e){
                        System.out.println("Mời bạn nhập lại");
                    }
                    break;
                case 3:
                    primaryStudentList.showPrimaryStudent();
                    break;
                case 4:
                    secondaryStudentList.showSecondaryStudent();
                    break;
                case 5:
                    int a = primaryStudentList.showPrimaryStudent() + secondaryStudentList.showSecondaryStudent();
                    System.out.println("Tổng số lượng Student đã thêm vào là: "+a);
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
            }


        }
    }

}
