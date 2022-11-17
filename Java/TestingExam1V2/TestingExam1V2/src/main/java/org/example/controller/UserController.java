package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void getListUsers() {
        try {
            userService.getListUser();
        }catch (Exception e){
            System.err.println("Lấy danh sách User không thành công");
        }
    }

    public void createUser(User user, String expInYear, String proSkill){
        try {
            userService.createUser(user,expInYear,proSkill);
        }catch (Exception e){
            System.err.println("Tạo User không thành công");
        }
    }

    public void getUserbyID(int userID){
        try {
            userService.getUserbyID(userID);
        }catch (Exception e){
            System.err.println("Lấy User không thành công");
        }
    }

    public void deleteUser(int userID){
        try {
            userService.deleteUser(userID);
        }catch (Exception e){
            System.err.println("Xoá User không thành công");
        }
    }

    public void loginUser(String email, String password){
        try {
            userService.loginUser(email,password);
        }catch (Exception e){
            System.err.println("Đăng nhập thất bại");
        }
    }
}
