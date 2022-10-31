package backend;

import entity.*;
import entity.Account;
import entity.Department;
import entity.Position;

import java.time.LocalDate;

public class Exercise_1_Constructor  {
    public static void Question1(){
        Department department1 = new Department("Bảo Vệ");
        System.out.println(department1);

    }
    public static void Question2(Position position1){
        Account account1 = new Account(1,"taoquan178@gmail.com","Quân","Trung","Quân");
        System.out.println("a: "+account1);

        Account account2 = new Account(2,"taoquan178@gmail.com","Quân","Trung","Quân",position1);
        System.out.println("b: "+account2);

        Account account3 = new Account(3,"taoquan178@gmail.com","Quân","Trung","Quân",position1, LocalDate.of(2022,5,5));
        System.out.println("c: chưa xong "+account3);
    }

    public static void Question3(Account[] accounts1){
        Group group1 = new Group("Testing System",1,accounts1,LocalDate.of(2019,3,5));
        System.out.println("a: không có parameters");
        System.out.println("b: "+group1);
        Group group2 = new Group("Development",2,accounts1,LocalDate.of(2020,3,7));
        System.out.println("c: "+group2);
    }
}