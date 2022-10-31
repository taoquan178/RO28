package frontend;

import static backend.Exercise_1_Constructor.*;

import entity.*;
import entity.Position;

import java.time.LocalDate;

public class Program1 {
    public static void main(String[] args) {
        /**
         * Question 1:
         * Tạo constructor cho department:
         * a) không có parameters
         * b) Có 1 parameter là nameDepartment và default id của
         * Department = 0
         * Khởi tạo 1 Object với mỗi constructor ở trên
         */
        System.out.println("Question 1:");
        Question1();
        /**
         * Question 2:
         * Tạo constructor cho Account:
         * a) Không có parameters
         * b) Có các parameter là id, Email, Username, FirstName,
         * LastName (với FullName = FirstName + LastName)
         * c) Có các parameter là id, Email, Username, FirstName,
         * LastName (với FullName = FirstName + LastName) và
         * Position của User, default createDate = now
         * d) Có các parameter là id, Email, Username, FirstName,
         * LastName (với FullName = FirstName + LastName) và
         * Position của User, createDate
         * Khởi tạo 1 Object với mỗi constructor ở trên
         */
        System.out.println("\n Question 2:");
        Position position1 = new Position();
        position1.setId(1);
        position1.setPositionName(Position.PositionName.PM);
        Question2(position1);
        /**
         * Question 3:
         * Tạo constructor cho Group:
         * a) không có parameters
         * b) Có các parameter là GroupName, Creator, array Account[]
         * accounts, CreateDate
         * c) Có các parameter là GroupName, Creator, array String[]
         * usernames , CreateDate
         * Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin
         * username, các thông tin còn lại = null).
         * Khởi tạo 1 Object với mỗi constructor ở trên
         */
        System.out.println("\n Question 3:");
        Account account1 = new Account();
        account1.setId(1);
        account1.setEmail("taoquan178@gmail.com");
        account1.setName("Quân");
        account1.setFullName("Nguyễn Trung Quân");
        account1.setPosition(position1);
        account1.setCreateDate(LocalDate.of(2021,5,5));

        Group group1 = new Group();
        Account[] accounts1 = new  Account[5];
        accounts1[0] = account1;
        group1.setAccounts(accounts1);
        Question3(accounts1);

    }

}
