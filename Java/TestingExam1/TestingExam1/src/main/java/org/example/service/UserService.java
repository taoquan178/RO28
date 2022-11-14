package org.example.service;

import org.example.entity.Admin;
import org.example.entity.Employee;
import org.example.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> getListUsers() throws SQLException;
    void createUserAdmin(User user, Admin admin) throws Exception;
    void createUserEmployee(User user, Employee employee) throws Exception;
    void getUserByID(int userID)throws SQLException;
    void deleteUserByID(int userID)throws SQLException;
    List<User> getList() throws SQLException;
    boolean login(String email,String password)throws Exception;;

}
