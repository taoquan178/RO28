package org.example.vti.menu;

import org.example.vti.controller.AccountController;
import org.example.vti.entity.Account;
import org.example.vti.repository.AccountRepository;
import org.example.vti.service.impl.AccountServiceImpl;
import org.example.vti.util.ScannerUtils;

import java.sql.SQLException;

public class menuAccount {
    public static void menuAccount() throws SQLException {
        AccountRepository aRepository = new AccountRepository();
        AccountServiceImpl aService = new AccountServiceImpl(aRepository);
        AccountController aController = new AccountController(aService);
        while (true){
            System.out.println("================Account================");
            System.out.println("1: Show account                       |");
            System.out.println("2: Create account                     |");
            System.out.println("3: Update account                     |");
            System.out.println("4: Delete account                     |");
            System.out.println("5: Get account by id                  |");
            System.out.println("0: Exit account                       |");
            System.out.println("==========================================");
            System.out.println("Mời bạn nhập lựa chọn: ");
            int choice = ScannerUtils.inputInt();
            switch (choice){
                case 0:
                    return;
                case 1:
                    aController.getListAccounts();
                    break;
                case 2:
                    System.out.println("Nhập vào Email: ");
                    String accountEmail = ScannerUtils.inputString();
                    System.out.println("Nhập vào tên của bạn: ");
                    String accountName = ScannerUtils.inputString();
                    System.out.println("Nhập vào tên đầy đủ của bạn: ");
                    String accountFullName = ScannerUtils.inputString();
                    System.out.println("Nhập vào dpartmentID: ");
                    int accountDepartmentID = ScannerUtils.checkDepartmentID();
                    System.out.println("Nhập vào PositionID từ 1-4: ");
                    int accountPositionID = ScannerUtils.checkPositionID();
                    Account account = new Account();
                    account.setEmail(accountEmail);
                    account.setName(accountName);
                    account.setFullName(accountFullName);
                    account.setDepartment(accountDepartmentID);
                    account.setPosition(accountPositionID);
                    long millis=System.currentTimeMillis();
                    java.sql.Date date = new java.sql.Date(millis);
                    account.setCreateDate(date);
                    aController.createAccount(account);
                    break;
                case 3:
                    System.out.println("Nhập vào id account muốn sửa: ");
                    int accountID1 = ScannerUtils.inputInt();
                    System.out.println("Nhập vào Email: ");
                    String accountEmail1 = ScannerUtils.inputString();
                    System.out.println("Nhập vào tên của bạn: ");
                    String accountName1 = ScannerUtils.inputString();
                    System.out.println("Nhập vào tên đầy đủ của bạn: ");
                    String accountFullName1 = ScannerUtils.inputString();
                    System.out.println("Nhập vào dpartmentID: ");
                    int accountDepartmentID1 = ScannerUtils.checkDepartmentID();
                    System.out.println("Nhập vào PositionID từ 1-4: ");
                    int accountPositionID1 = ScannerUtils.checkPositionID();
                    Account account1 = new Account();
                    account1.setId(accountID1);
                    account1.setEmail(accountEmail1);
                    account1.setName(accountName1);
                    account1.setFullName(accountFullName1);
                    account1.setDepartment(accountDepartmentID1);
                    account1.setPosition(accountPositionID1);
                    aController.updateAccount(account1);
                    break;
                case 4:
                    System.out.println("Nhập account id bạn muốn xoá: ");
                    int deleteAccountID = ScannerUtils.inputInt();
                    Account account2 = new Account();
                    account2.setId(deleteAccountID);
                    aController.deleteAccount(account2);
                    break;
                case 5:
                    System.out.println("Nhập account id bạn muốn tìm kiếm: ");
                    int searchAccountID = ScannerUtils.inputInt();
                    Account account3 = new Account();
                    account3.setId(searchAccountID);
                    aController.searchAccountID(account3);
                    break;
                default:
                    System.err.println("Bạn nhập vào sai! Mời bạn nhập lại cho đúng");
            }
        }
    }
}
