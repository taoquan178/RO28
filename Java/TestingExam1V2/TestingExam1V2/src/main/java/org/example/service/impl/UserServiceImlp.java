package org.example.service.impl;

import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.example.util.Utils;
import java.sql.SQLException;

import java.util.List;

import static org.example.Main.menuAdmin;
import static org.example.Main.menuEmployee;

public class UserServiceImlp implements UserService {
    private final UserRepository userRepository;

    public UserServiceImlp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void getListUser() throws SQLException {
        List<User> userList = userRepository.getListUsers();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Override
    public void createUser(User user,String expInYear, String proSkill) throws SQLException {
        int result = userRepository.createUser(user, expInYear, proSkill);
        if (result > 0){
            System.out.println("tạo user thành công!");
        }else {
            System.err.println("Tạo data user không thành công");
        }
    }

    @Override
    public void deleteUser(int userId) throws SQLException {
        List<User> userList = userRepository.getListUsers();
        boolean checkUserID = Utils.checkUserID(userList,userId);
        if (checkUserID){
            int result = userRepository.deleteUserbyID(userId);
            if (result > 0){
                System.out.println("Xoá thành công!");
            }else {
                System.err.println("Xoá không thành công!");
            }
        }else {
            System.err.println("Không có user id này!");
        }
    }

    @Override
    public void getUserbyID(int userId) throws SQLException {
        List<User> userList = userRepository.getListUsers();
        boolean checkUserID = Utils.checkUserID(userList,userId);
        if (checkUserID){
            for (User user : userList) {
                if (user.getId() == userId){
                    System.out.println(user);
                }
            }
        }else {
            System.err.println("Không có user id này!");
        }
    }

    @Override
    public void loginUser(String email, String password) throws SQLException {
        List<User> userList = userRepository.getListUsers();
        int checkEmailLogin = Utils.checkEmailLogin(userList,email);
        int checkPasswordLogin = Utils.checkPasswordLogin(userList,password);
        if (checkEmailLogin == 1 && checkPasswordLogin == 1){
            System.out.println("Đăng nhập account Admin thành công!");
            menuAdmin();
        } else if (checkPasswordLogin == 2 && checkEmailLogin == 2){
            System.out.println("Đăng nhập account Employee thành công!");
            menuEmployee();
        } else if (checkEmailLogin == 1 && checkPasswordLogin == 2){
            System.err.println("Mật khẩu không đúng!");
        } else  if (checkEmailLogin == 2 && checkPasswordLogin == 1){
            System.err.println("Email không đúng!");
        } else {
            System.err.println("Email và mật khẩu không đúng.");
        }
    }
}
