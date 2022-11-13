package org.example.vti.service;

import org.example.vti.entity.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountService {
    List<Account> getListAccounts() throws SQLException;
    void createAccount(Account account) throws SQLException;
    void updateAccount(Account account) throws SQLException;
    void deleteAccount(Account account) throws SQLException;
    void searchAccountID(Account account) throws SQLException;
}
