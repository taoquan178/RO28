package org.example.vti.controller;

import org.example.vti.entity.Account;
import org.example.vti.service.AccountService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public List<Account> getListAccounts(){
        List<Account> accounts = new ArrayList<>();
        try {
            accounts = accountService.getListAccounts();
            for (Account account : accounts) {
                System.out.println(account);
            }
        }catch (Exception e){
            System.err.println("Lấy danh sách account không thành công!");
        }
        return accounts;
    }

    public void createAccount(Account account){
        try {
            accountService.createAccount(account);
        }catch (Exception e){
            System.err.println("Tạo account thất bại!");
        }
    }

    public void updateAccount(Account account){
        try {
            accountService.updateAccount(account);
        }catch (Exception e){
            System.err.println("Cập nhật account thất bại!");
        }
    }

    public void deleteAccount(Account account){
        try {
            accountService.deleteAccount(account);
        }catch (Exception e){
            System.err.println("Xoá account thất bại!");
        }
    }

    public void searchAccountID(Account account) {
        try {
            accountService.searchAccountID(account);
        }catch (Exception e){
            System.err.println("Tìm account thất bại!");
        }
    }
}
