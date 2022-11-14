package org.example;

import org.example.controller.UserController;
import org.example.entity.Admin;
import org.example.entity.Employee;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.service.impl.UserserviceImpl;
import org.example.utils.ScannerUtils;

public class MenuAdmin {
    public static void menuAdmin() {
        UserRepository repository = new UserRepository();
        UserserviceImpl viceImpl = new UserserviceImpl(repository);
        UserController controller = new UserController(viceImpl);
        while (true) {
            System.out.println("================Menu Admin==============");
            System.out.println("1: Create user                           |");
            System.out.println("2: Show list user Admin,Employee         |");
            System.out.println("3: Get user by id                        |");
            System.out.println("4: Delete user by id                     |");
            System.out.println("5: Show list user                        |");
            System.out.println("0: Exit Menu Admin                       |");
            System.out.println("==========================================");
            System.out.println("Mời bạn nhập lựa chọn: ");
            int choice = ScannerUtils.inputInt();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    System.out.println("Nhập vào họ tên user: ");
                    String fullName = ScannerUtils.inputString();
                    System.out.println("Nhập vào email: ");
                    String email = ScannerUtils.inputString();
                    System.out.println("Nhập vào password: ");
                    String password = ScannerUtils.inputStringV2();
                    User user = new User(0, fullName, email, password);
                    System.out.println("Mời bạn chọn loại user muốn tạo: ");
                    System.out.println("1: Tạo user Admin - 2: Tạo user Employee");
                    int choiceUser = ScannerUtils.inputInt();
                    switch (choiceUser) {
                        case 1:
                            System.out.println("Nhập số năm kinh nghiệm: ");
                            int expInYear = ScannerUtils.inputInt();
                            Admin admin = new Admin(expInYear);
                            controller.createUserAdmin(user, admin);
                            break;
                        case 2:
                            System.out.println("Nhập kỹ năng chuyên môn: ");
                            String proSkill = ScannerUtils.inputString();
                            Employee employee = new Employee(proSkill);
                            controller.createUserEmployee(user, employee);
                            break;
                        default:
                            System.out.println("Bạn chỉ được chọn 1 hoặc 2 ");
                    }
                    break;
                case 2:
                    controller.getListUsers();
                    break;
                case 3:
                    System.out.println("Mời bạn nhập vào id user cần tìm: ");
                    int getUserByID = ScannerUtils.inputInt();
                    controller.getUserByID(getUserByID);
                    break;
                case 4:
                    System.out.println("Mời bạn nhập vào id user cần xoá: ");
                    int deleteUserByID = ScannerUtils.inputInt();
                    controller.deleteUserByID(deleteUserByID);
                    break;
                case 5:
                    controller.getList();
                    break;
                default:
                    System.err.println("Bạn nhập vào sai! Mời bạn nhập lại cho đúng");
            }
        }
    }
}
