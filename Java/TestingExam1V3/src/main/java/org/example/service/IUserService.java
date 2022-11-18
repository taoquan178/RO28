package org.example.service;

import org.example.entity.User;

import java.sql.SQLException;

public interface IUserService {
    void getListUser() throws SQLException;
    void createUser(User user,String expInYear, String proSkill) throws SQLException;
    void getUserByid(int userId) throws SQLException;
    void deleteUserByid(int userId) throws SQLException;
    void loginUser(String email, String password) throws SQLException;
}
