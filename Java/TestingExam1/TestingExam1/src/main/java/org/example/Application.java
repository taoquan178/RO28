package org.example;

import org.example.controller.UserController;
import org.example.repository.UserRepository;
import org.example.service.impl.UserserviceImpl;
import org.example.utils.ScannerUtils;

public class Application {
    public static void main(String[] args) {
        UserRepository repository = new UserRepository();
        UserserviceImpl viceImpl = new UserserviceImpl(repository);
        UserController controller = new UserController(viceImpl);
        while (true){
            System.out.println("==============Menu Application============");
            System.out.println("1: Login user                            |");
            System.out.println("2: Show list user Admin,Employee         |");
            System.out.println("0: Exit application                      |");
            System.out.println("==========================================");
            System.out.println("Mời bạn nhập lựa chọn: ");
            int choice = ScannerUtils.inputInt();
            switch (choice){
                case 0:
                    return;
                case 1:
                    System.out.println("Mời bạn nhập vào email đăng nhập: ");
                    String loginEmail = ScannerUtils.inputString();
                    System.out.println("Mời bạn nhập vào password: ");
                    String loginPasswordl = ScannerUtils.inputString();
                    controller.login(loginEmail,loginPasswordl);
                    break;
                case 2:
                    controller.getListUsers();
                    break;
                default:
                    System.err.println("Bạn nhập vào sai! Mời bạn nhập lại cho đúng");
            }
        }
    }
}
