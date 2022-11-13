package org.example.vti;

import org.example.vti.util.DatabaseUtil;
import org.example.vti.util.ScannerUtils;

import java.sql.SQLException;

import static org.example.vti.menu.MenuDepartment.menuDepartment;
import static org.example.vti.menu.MenuPosition.menuPosition;
import static org.example.vti.menu.menuAccount.menuAccount;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseUtil db = new DatabaseUtil();
        db.getDatabaseConnection();
        while (true){
            System.out.println("================Menu Project==============");
            System.out.println("1: Position                              |");
            System.out.println("2: Department                            |");
            System.out.println("3: Account                               |");
            System.out.println("0: Exit project                          |");
            System.out.println("==========================================");
            System.out.println("Mời bạn nhập lựa chọn: ");
            int choice = ScannerUtils.inputInt();
            switch (choice){
                case 0:
                    return;
                case 1:
                    menuPosition();
                    break;
                case 2:
                    menuDepartment();
                    break;
                case 3:
                    menuAccount();
                    break;
                default:
                    System.err.println("Bạn nhập vào sai! Mời bạn nhập lại cho đúng");
            }
        }
    }
}