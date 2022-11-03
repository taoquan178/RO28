package BackEnd;
import Entity.*;

import java.util.Scanner;

public class Exercise_2_Polymorphism_Q3 {
    public static void  Question3(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số a: ");
        float a = scanner.nextFloat();
        System.out.print("Nhập vào số b: ");
        float b = scanner.nextFloat();
        HinhChuNhat hinhChuNhat = new HinhChuNhat(a,b);
        HinhVuong hinhVuong = new HinhVuong(a);
        System.out.println("Chu vi hình chữ nhật");
        hinhChuNhat.TinhChuVi();
        System.out.println("Diện tích hình chữ nhật");
        hinhChuNhat.TinhDienTich();
        System.out.println("Chu vi hình vuông");
        hinhVuong.TinhChuVi();
        System.out.println("Diện tích hình vuông");
        hinhVuong.TinhDienTich();
    }
}
