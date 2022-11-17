package org.example;

import org.example.controller.UserController;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.service.impl.UserServiceImlp;
import org.example.util.ScannerUtils;

public class Main {
    final static UserRepository repository = new UserRepository();
    final static UserServiceImlp ServiceImlp = new UserServiceImlp(repository);
    final static UserController controller = new UserController(ServiceImlp);
    public static void main(String[] args) {

        while (true) {
            System.out.println("=================Menu Login===============");
            System.out.println("1: Login account                         |");
            System.out.println("2: Account admin để test                 |");
            System.out.println("0: Exit                                  |");
            System.out.println("==========================================");
            System.out.println("Mời bạn nhập lựa chọn: ");
            int choice = ScannerUtils.inputInt();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    System.out.println("Nhập vào email: ");
                    String eamilAdmin = ScannerUtils.inputStringEmail();
                    System.out.println("Nhập vào password: ");
                    String passwordAdmin = ScannerUtils.inputString();
                    controller.loginUser(eamilAdmin,passwordAdmin);
                    break;
                case 2:
                    System.out.println("Email: taoquan178@gmail.com - Password: 12345Quan");
                    break;
                default:
                    System.err.println("Bạn nhập vào sai! Mời bạn nhập lại cho đúng");
            }
        }
    }

    public static void menuAdmin(){
        while (true) {
            System.out.println("=================Menu Admin===============");
            System.out.println("1: Show list user                        |");
            System.out.println("2: Create user                           |");
            System.out.println("3: Get user by id                        |");
            System.out.println("4: Delete user by id                     |");
            System.out.println("5: Create employee                       |");
            System.out.println("0: Exit Menu Admin                       |");
            System.out.println("==========================================");
            System.out.println("Mời bạn nhập lựa chọn: ");
            int choice = ScannerUtils.inputInt();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    controller.getListUsers();
                    break;
                case 2:
                    User user = new User();
                    System.out.println("Nhập tên user: ");
                    String userName = ScannerUtils.inputStringFullName();
                    user.setFullName(userName);
                    System.out.println("Nhập email: ");
                    String userEmail = ScannerUtils.inputStringEmail();
                    user.setEmail(userEmail);
                    System.out.println("Nhập password: ");
                    String userPassword = ScannerUtils.inputStringPassword();
                    user.setPassword(userPassword);
                    System.out.println("Chọn type user: 1: Admin - 2: Employee");
                    int typeUser = ScannerUtils.inputInt();
                    switch (typeUser){
                        case 1:
                            user.setTypeUser("Admin");
                            System.out.println("Nhập số năm kinh nghiệm: ");
                            String userExpInYear = ScannerUtils.inputString();
                            controller.createUser(user,userExpInYear,"");
                            break;
                        case 2:
                            user.setTypeUser("Employee");
                            System.out.println("Nhập kỹ năng chuyên môn: ");
                            String userProSkill = ScannerUtils.inputString();
                            controller.createUser(user,"",userProSkill);
                            break;
                        default:
                            System.out.println("Mời bạn nhập lại cho đúng");
                    }
                    break;
                case 3:
                    System.out.println("Mời bạn nhập vào userID cần tìm: ");
                    int userID = ScannerUtils.inputInt();
                    controller.getUserbyID(userID);
                    break;
                case 4:
                    System.out.println("Mời bạn nhập vào userID cần xoá: ");
                    int userID1 = ScannerUtils.inputInt();
                    controller.deleteUser(userID1);
                    break;
                case 5:
                    User user1 = new User();
                    System.out.println("Nhập tên user: ");
                    String userName1 = ScannerUtils.inputStringFullName();
                    System.out.println("Nhập email: ");
                    String userEmail1 = ScannerUtils.inputStringEmail();
                    System.out.println("Nhập kỹ năng chuyên môn: ");
                    String userProSkill1 = ScannerUtils.inputString();
                    user1.setFullName(userName1);
                    user1.setEmail(userEmail1);
                    user1.setPassword("123456");
                    user1.setTypeUser("Employee");
                    controller.createUser(user1,"",userProSkill1);
                    break;
                default:
                    System.err.println("Bạn nhập vào sai! Mời bạn nhập lại cho đúng");
            }
        }
    }

    public static void menuEmployee(){
        while (true) {
            System.out.println("===============Menu Employee==============");
            System.out.println("1: Show list user                        |");
            System.out.println("2: Get user by id                        |");
            System.out.println("0: Exit Menu Employee                    |");
            System.out.println("==========================================");
            System.out.println("Mời bạn nhập lựa chọn: ");
            int choice = ScannerUtils.inputInt();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    controller.getListUsers();
                    break;
                case 2:
                    System.out.println("Mời bạn nhập vào userID cần tìm: ");
                    int userID = ScannerUtils.inputInt();
                    controller.getUserbyID(userID);
                    break;
                default:
                    System.err.println("Bạn nhập vào sai! Mời bạn nhập lại cho đúng");
            }
        }
    }
}