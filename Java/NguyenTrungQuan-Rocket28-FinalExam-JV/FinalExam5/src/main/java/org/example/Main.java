package org.example;

import org.example.controller.UserController;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.service.Impl.UserServiceImpl;
import org.example.util.ScannerUtils;

public class Main {
    private final static UserRepository repository = new UserRepository();
    private final static UserServiceImpl ServiceImlp = new UserServiceImpl(repository);
    private final static UserController controller = new UserController(ServiceImlp);
public static void main(String[] args) {
    while (true) {
        System.out.println("=================Menu Login===============");
        System.out.println("1: Login account                         |");
        System.out.println("2: Account để test chương trình          |");
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
                System.out.println("Account Admin - Email: taoquan178@gmail.com - Password: 12345Quan");
                System.out.println("Account Manager - Email: vanphuc123@gmail.com - Password: 12345Phuc");
                System.out.println("Account Employee - Email: trungtoan123@gmail.com - Password: 12345Toan");
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
            System.out.println("2: Get User By Project Id                |");
            System.out.println("3: Create type user                      |");
            System.out.println("4: Create user employee                  |");
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
                    System.out.println("Mời bạn nhập vào Project Id: ");
                    int projectId1 = ScannerUtils.inputInt();
                    controller.getUserByProjectId(projectId1);
                    break;
                case 3:
                    System.out.println("Nhập đầy đủ họ tên bạn: ");
                    String userFullName = ScannerUtils.inputStringFullName();
                    System.out.println("Nhập email của bạn: ");
                    String userEmail = ScannerUtils.inputStringEmail();
                    System.out.println("Nhập password của bạn: ");
                    String userPassword = ScannerUtils.inputStringPassword();
                    User user = new User();
                    user.setFullName(userFullName);
                    user.setEmail(userEmail);
                    user.setPassword(userPassword);
                    System.out.println("Chọn type user 1: Admin - 2: Employee - 3: Manager");
                    int choice1 = ScannerUtils.inputInt();
                    switch (choice1){
                        case 1:
                            user.setTypeUser("Admin");
                            controller.createUser(user);
                            break;
                        case 2:
                            System.out.println("Nhập vào project Id: ");
                            int projectId = ScannerUtils.inputInt();
                            System.out.println("Nhập vào kỹ năng chuyên môn của bạn; ");
                            String proSkill = ScannerUtils.inputString();
                            user.setTypeUser("Employee");
                            controller.createUserEmployee(user,projectId,proSkill);
                            break;
                        case 3:
                            System.out.println("Nhập vào số năm kinh nghiệm của bạn: ");
                            int expInYear = ScannerUtils.inputInt();
                            System.out.println("Nhập vào project Id: ");
                            int projectId2 = ScannerUtils.inputInt();
                            user.setTypeUser("Manager");
                            controller.createUserManager(user, projectId2, expInYear);
                            break;
                        default:
                            System.err.println("Bạn chỉ được nhập vào 1 hoặc 2!!");
                    }
                    break;
                case 4:
                    System.out.println("Nhập đầy đủ họ tên bạn: ");
                    String userFullName1 = ScannerUtils.inputStringFullName();
                    System.out.println("Nhập email của bạn: ");
                    String userEmail1 = ScannerUtils.inputStringEmail();
                    User user1 = new User();
                    user1.setFullName(userFullName1);
                    user1.setEmail(userEmail1);
                    user1.setPassword("123456");
                    user1.setTypeUser("Employee");
                    controller.createUser(user1);
                    break;
                default:
                    System.err.println("Bạn nhập vào sai! Mời bạn nhập lại cho đúng");
            }
        }
    }
    public static void menuEmployeeAndManager() {
        while (true) {
            System.out.println("==================Menu===================");
            System.out.println("1: Show list user                        |");
            System.out.println("2: Get User By Project Id                |");
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
                    System.out.println("Mời bạn nhập vào Project Id: ");
                    int projectId1 = ScannerUtils.inputInt();
                    controller.getUserByProjectId(projectId1);
                    break;
                case 3:

                    break;
                default:
                    System.err.println("Bạn nhập vào sai! Mời bạn nhập lại cho đúng");
            }
        }
    }
}
