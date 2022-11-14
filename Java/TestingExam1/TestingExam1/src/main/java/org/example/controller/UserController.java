package org.example.controller;

import org.example.entity.Admin;
import org.example.entity.Employee;
import org.example.entity.User;
import org.example.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.example.MenuAdmin.menuAdmin;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public List<User> getListUsers(){
        List<User> users = new ArrayList<>();
        try {
            users = userService.getListUsers();
            for (User user : users){
                System.out.println(user);
            }
        }catch (Exception e){
            System.err.println("Lấy danh sách user không thành công! "+ e.getMessage());
        }
        return users;
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

    public List<User> getList(){
        List<User> users = new ArrayList<>();
        try {
            users = userService.getList();
            for (User user : users){
                System.out.println("ID: "+user.getId()+"- FullName: "+ user.getName() + "- Email: "+ user.getEmail());
            }
        }catch (Exception e){
            System.err.println("Lấy danh sách user không thành công! "+ e.getMessage());
        }
        return users;
    }

    public void login(String email, String password){
        try {
            boolean loginAdmin = userService.login(email,password);
            if (loginAdmin){
                System.out.println("Đăng nhập thành công!");
                menuAdmin();
            }
        }catch (Exception e){
            System.err.println("Đăng nhập thất bại!");
        }
    }
}
