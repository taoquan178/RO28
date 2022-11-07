package backend.exercise1;

import entity.StudentEx1;

import java.util.Scanner;

public class Question4 {
    public void Question4(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Giá trị ban đầu");
        StudentEx1 studentEx1 = new StudentEx1();
        studentEx1.setCollege("Trường Đại Học Kinh Doanh Và Công Nghệ Hà Nội");
        System.out.println(StudentEx1.getCollege());

        System.out.println("Set lại college: ");
        String college = scanner.nextLine();
        studentEx1.setCollege(college);
        System.out.println(StudentEx1.getCollege());

    }
}
