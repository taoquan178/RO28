package org.example.controller;

import org.example.entity.User;
import org.example.service.IUserService;

public class UserController {
    private final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    public void getListUsers() {
        try {
            iUserService.getListUser();
        }catch (Exception e){
            System.err.println("Lấy danh sách user không thành công!"+ e.getMessage());
        }
    }

    public void createUser(User user, String expInYear, String proSkill){
        try {
            iUserService.createUser(user,expInYear,proSkill);
        }catch (Exception e){
            System.err.println("Thêm user không thành công!"+ e.getMessage());
        }
    }

    public void getUserByid(int userId){
        try {
            iUserService.getUserByid(userId);
        }catch (Exception e){
            System.err.println("Tìm kiếm user không thành công!"+ e.getMessage());
        }
    }

    public void deleteUserByid(int userId){
        try {
            iUserService.deleteUserByid(userId);
        }catch (Exception e){
            System.err.println("Xoá user không thành công!"+ e.getMessage());
        }
    }

    public void loginUser(String email, String password){
        try {
            iUserService.loginUser(email,password);
        }catch (Exception e){
            System.err.println("Đăng nhập không thành công!"+ e.getMessage());
        }
    }
}
