package org.example.controller;

import org.example.entity.User;
import org.example.service.IUserservice;

public class UserController {
    private final IUserservice iUserservice;

    public UserController(IUserservice iUserservice) {
        this.iUserservice = iUserservice;
    }

    public void getListUsers() {
        try {
            iUserservice.getListUsers();
        }catch (Exception e){
            System.err.println("Lấy danh sách không thành công!");
        }
    }

    public void getUserByProjectId(int projectId){
        try {
            iUserservice.getUserByProjectId(projectId);
        }catch (Exception e){
            System.err.println("Lấy danh sách không thành công!");
        }
    }

    public void loginUser(String email, String password){
        try {
            iUserservice.loginUser(email,password);
        }catch (Exception e){
            System.err.println("Đăng nhập không thành công!");
        }
    }

    public void createUser(User user){
        try {
            iUserservice.createUser(user);
        }catch (Exception e){
            System.err.println("Tạo user không thành công!");
        }
    }
    public void createUserManager(User user, int projectId, int expInYear){
        try {
            iUserservice.createUserManager(user,projectId,expInYear);
        }catch (Exception e){
            System.err.println("Tạo user không thành công!");
        }
    }
    public void createUserEmployee(User user, int projectId, String proSkill){
        try {
            iUserservice.createUserEmployee(user,projectId,proSkill);
        }catch (Exception e){
            System.err.println("Tạo user không thành công!");
        }
    }
}

