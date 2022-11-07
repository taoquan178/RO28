package backend.exercise1;

import entity.StudentEx1;

import java.util.Scanner;

public class Question5 {
    public void Question5() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên Student thứ 1: ");
        String st1Name = scanner.next();
        System.out.println("Nhập tên Student thứ 2: ");
        String st2Name = scanner.next();
        System.out.println("Nhập tên Student thứ 3: ");
        String st3Name = scanner.next();
        StudentEx1 st1 = new StudentEx1(st1Name);
        StudentEx1 st2 = new StudentEx1(st2Name);
        StudentEx1 st3 = new StudentEx1(st3Name);
        System.out.println(st1);
        System.out.println(st2);
        System.out.println(st3);
        System.out.println("Số Student đươc tạo là: " + StudentEx1.COUNT);
    }
}
