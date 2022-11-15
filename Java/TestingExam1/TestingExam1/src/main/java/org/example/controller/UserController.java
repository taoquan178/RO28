package org.example.controller;

import org.example.entity.Admin;
import org.example.entity.Employee;
import org.example.entity.User;
import org.example.service.UserService;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void getListUsers(){
        try {
            userService.getListUsers();
        }catch (Exception e){
            System.err.println("Lấy danh sách user không thành công! "+ e.getMessage());
        }
    }

    public void createUserAdmin(User user,Admin admin){
        try {
            userService.createUserAdmin(user,admin);
        }catch (Exception e){
            System.err.println("Tạo mới user admin không thành công! " + e.getMessage());
        }
    }

    public void createUserEmployee(User user,Employee employee){
        try {
            userService.createUserEmployee(user,employee);
        }catch (Exception e){
            System.err.println("Tạo mới user employee không thành công! " + e.getMessage());
        }
    }

    public void deleteUserByID(int userID){
        try {
            userService.deleteUserByID(userID);
        }catch (Exception e){
            System.err.println("Xoá user không thành công! " + e.getMessage());
        }
    }

    public void getUserByID(int userID){
        try {
            userService.getUserByID(userID);
        }catch (Exception e){
            System.err.println("Tìm id không thành công!" + e.getMessage());
        }
    };

    public void getList(){
        try {
            userService.getList();
        }catch (Exception e){
            System.err.println("Lấy danh sách user không thành công! "+ e.getMessage());
        }
    }

    public void login(String email, String password){
        try {
            userService.login(email,password);
        }catch (Exception e){
            System.err.println("Đăng nhập thất bại!");
        }
    }
}
