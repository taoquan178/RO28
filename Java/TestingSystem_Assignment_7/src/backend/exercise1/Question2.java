package backend.exercise1;

import entity.StudentEx1;

import java.util.Scanner;

public class Question2 {
    public void Question2() {
        StudentEx1[] student = new StudentEx1[3];
        student[0] = new StudentEx1("Quân");
        student[1] = new StudentEx1("Hiếu");
        student[2] = new StudentEx1("Trang");

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số tiền đóng quỹ lớp: ");
        int groupMoney = sc.nextInt();
        for(StudentEx1 studentArray : student){
            studentArray.payClass(groupMoney);
            System.out.println(studentArray.getName()+" Đóng "+ groupMoney +"k tiền quỹ lớp");
        }
        System.out.println("Tổng quỹ lớp: "+ StudentEx1.getMoneyGroup());

        System.out.println("Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan");
        student[0].minusClassFund(50);
        System.out.println("Student thứ 2 lấy 20k đi mua bánh mì");
        student[1].minusClassFund(20);
        System.out.println("Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm");
        student[2].minusClassFund(150);

        System.out.print("Nhập số tiền đóng quỹ lớp: ");
        int groupMoney1 = sc.nextInt();
        for(StudentEx1 studentArray : student){
            studentArray.payClass(groupMoney1);
            System.out.println(studentArray.getName()+" Đóng "+ groupMoney1 +"k tiền quỹ lớp");
        }
        System.out.println("Tổng quỹ lớp: "+ StudentEx1.getMoneyGroup());

    }

}
