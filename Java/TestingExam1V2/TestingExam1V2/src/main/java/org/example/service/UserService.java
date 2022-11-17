package org.example.service;

import org.example.entity.User;

import java.sql.SQLException;

public interface UserService {
    void getListUser() throws SQLException;
    void createUser(User user, String expInYear, String proSkill) throws SQLException;
    void deleteUser(int userId) throws SQLException;
    void getUserbyID(int userId) throws SQLException;
    void loginUser(String email, String password) throws SQLException;

}
