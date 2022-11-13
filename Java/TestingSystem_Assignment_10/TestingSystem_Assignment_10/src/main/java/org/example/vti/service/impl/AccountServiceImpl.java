package org.example.vti.service.impl;

import org.example.vti.entity.Account;
import org.example.vti.repository.AccountRepository;
import org.example.vti.service.AccountService;
import org.example.vti.util.Utils;

import java.sql.SQLException;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getListAccounts() throws SQLException {
        return accountRepository.getListAccounts();
    }

    @Override
    public void createAccount(Account account) throws SQLException {
        int result = accountRepository.createAccount(account);
        if (result > 0){
            System.out.println("Tạo dữ liệu account thành công");
        }else {
            System.err.println("Tạo dữ liệu account thất bại!");
        }
    }

    @Override
    public void updateAccount(Account account) throws SQLException {
        List<Account> accounts = getListAccounts();
        boolean validate = Utils.validateAccount(accounts,account);
        if (validate){
            int result = accountRepository.updateAccount(account);
            if (result > 0){
                System.out.println("Cập nhập dữ liệu account thành công");
            }else {
                System.err.println("Cập nhập dữ liệu account thất bại!");
            }
        }else {
            System.err.println("Không có id này!");
        }
    }

    @Override
    public void deleteAccount(Account account) throws SQLException {
        List<Account> accounts = accountRepository.getListAccounts();
        boolean validate = Utils.validateAccount(accounts,account);
        if (validate){
            int result = accountRepository.deleteAccount(account);
            if (result > 0){
                System.out.println("Xoá dữ liệu account thành công");
            }else {
                System.err.println("Xoá dữ liệu account thất bại!");
            }
        }else {
            System.err.println("Không có id này!");
        }
    }

    @Override
    public void searchAccountID(Account account) throws SQLException {
        List<Account> accounts = accountRepository.getListAccounts();
        boolean a = true;
        for (Account accountArry : accounts){
            if (accountArry.getId() == account.getId()){
                System.out.println(accountArry);
                a = false;
            }
        }
        if (a){
            System.err.println("Không có id này!");
        }

    }

}
