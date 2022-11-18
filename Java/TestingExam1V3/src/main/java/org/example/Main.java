package org.example;

import org.example.controller.UserController;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.service.Impl.UserServiceImpl;
import org.example.util.ScannerUtils;

public class Main {
    static final UserRepository repository = new UserRepository();
    static final UserServiceImpl impl = new UserServiceImpl(repository);
    static final UserController controller = new UserController(impl);
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
                    System.out.println("Nhập email: ");
                    String email = ScannerUtils.inputStringEmail();
                    System.out.println("Nhập password; ");
                    String password = ScannerUtils.inputString();
                    controller.loginUser(email,password);
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
            System.out.println("4: delete user by id                     |");
            System.out.println("5: Create user employee                  |");
            System.out.println("0: Exit                                  |");
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
                    System.out.println("Nhập đầy đủ họ tên bạn: ");
                    String userFullName = ScannerUtils.inputStringFullName();
                    System.out.println("Nhập email của bạn: ");
                    String userEmail = ScannerUtils.inputStringEmail();
                    System.out.println("Nhập password của bạn: ");
                    String userPassword = ScannerUtils.inputStringPassword();
                    User user = new User();
                    user.setFullname(userFullName);
                    user.setEmail(userEmail);
                    user.setPassword(userPassword);
                    System.out.println("Chọn type user 1: Admin - 2: Employee");
                    int choice1 = ScannerUtils.inputInt();
                    switch (choice1){
                        case 1:
                            System.out.println("Nhập vào số năm kinh nghiệm của bạn: ");
                            int expInYear = ScannerUtils.inputInt();
                            String expInYearString = String.valueOf(expInYear);
                            user.setTypeUser("Admin");
                            controller.createUser(user,expInYearString,"");
                            break;
                        case 2:
                            System.out.println("Nhập vào kỹ năng chuyên môn của bạn; ");
                            String proSkill = ScannerUtils.inputString();
                            user.setTypeUser("Employee");
                            controller.createUser(user,"",proSkill);
                            break;
                        default:
                            System.err.println("Bạn chỉ được nhập vào 1 hoặc 2!!");
                    }
                    break;
                case 3:
                    System.out.println("Nhập user id bạn cần tìm: ");
                    int getUserById = ScannerUtils.inputInt();
                    controller.getUserByid(getUserById);
                    break;
                case 4:
                    System.out.println("Nhập user id bạn cần tìm: ");
                    int deleteUserById = ScannerUtils.inputInt();
                    controller.deleteUserByid(deleteUserById);
                    break;
                case 5:
                    System.out.println("Nhập đầy đủ họ tên bạn: ");
                    String userFullName1 = ScannerUtils.inputStringFullName();
                    System.out.println("Nhập email của bạn: ");
                    String userEmail1 = ScannerUtils.inputStringEmail();
                    System.out.println("Nhập vào kỹ năng chuyên môn của bạn; ");
                    String proSkill1 = ScannerUtils.inputString();
                    User user1 = new User();
                    user1.setFullname(userFullName1);
                    user1.setEmail(userEmail1);
                    user1.setPassword("123456");
                    user1.setTypeUser("Employee");
                    controller.createUser(user1,"",proSkill1);
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
            System.out.println("2: Create user employee                  |");
            System.out.println("3: Get user by id                        |");
            System.out.println("0: Exit                                  |");
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
                    System.out.println("Nhập đầy đủ họ tên bạn: ");
                    String userFullName = ScannerUtils.inputStringFullName();
                    System.out.println("Nhập email của bạn: ");
                    String userEmail = ScannerUtils.inputStringEmail();
                    System.out.println("Nhập password của bạn: ");
                    String userPassword = ScannerUtils.inputStringPassword();
                    User user = new User();
                    user.setFullname(userFullName);
                    user.setEmail(userEmail);
                    user.setPassword(userPassword);
                    System.out.println("Nhập vào kỹ năng chuyên môn của bạn; ");
                    String proSkill = ScannerUtils.inputString();
                    user.setTypeUser("Employee");
                    controller.createUser(user,"",proSkill);
                    break;
                case 3:
                    System.out.println("Nhập user id bạn cần tìm: ");
                    int getUserById = ScannerUtils.inputInt();
                    controller.getUserByid(getUserById);
                    break;
                default:
                    System.err.println("Bạn nhập vào sai! Mời bạn nhập lại cho đúng");
            }
        }
    }
}