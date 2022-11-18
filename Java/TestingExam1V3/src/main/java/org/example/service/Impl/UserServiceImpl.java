package org.example.service.Impl;

import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.service.IUserService;
import org.example.util.Utils;

import java.sql.SQLException;
import java.util.List;

import static org.example.Main.menuAdmin;
import static org.example.Main.menuEmployee;

public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
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
    public void createUser(User user, String expInYear, String proSkill) throws SQLException {
        int result = userRepository.createUser(user,expInYear,proSkill);
        if (result>0){
            System.out.println("Thêm data user thành công!");
        }else {
            System.err.println("Thêm data user không thành công!");
        }
    }

    @Override
    public void getUserByid(int userId) throws SQLException {
        List<User> userList = userRepository.getListUsers();
        boolean checkUserId = Utils.checkUserId(userList,userId);
        if (checkUserId){
            for (User user : userList) {
                if (user.getId() == userId){
                    System.out.println(user);
                }
            }
        }else {
            System.err.println("Không có userId này!");
        }
    }

    @Override
    public void deleteUserByid(int userId) throws SQLException {
        List<User> userList = userRepository.getListUsers();
        boolean checkUserId = Utils.checkUserId(userList,userId);
        if (checkUserId){
            int result = userRepository.deleteUserById(userId);
            if (result>0){
                System.out.println("Xoá user thành công!");
            }else {
                System.err.println("Xoá data user thất bại!");
            }
        }else {
            System.err.println("Không có userId này!");
        }
    }

    @Override
    public void loginUser(String email, String password) throws SQLException {
        List<User> userList = userRepository.getListUsers();
        int checkEmailLogin = Utils.checkEmailLogin(userList,email);
        int checkPasswordLogin = Utils.checkPasswordLogin(userList,password);
        if (checkEmailLogin == 1 && checkPasswordLogin == 1){
            System.out.println("Đăng nhập user admin thành công!");
            menuAdmin();
        } else if (checkPasswordLogin == 2 && checkEmailLogin == 2){
            System.out.println("Đăng nhập user employee thành công!");
            menuEmployee();
        }else if(checkEmailLogin == 1 && checkPasswordLogin == 2){
            System.err.println("Mật khẩu không đúng");
        }else if(checkEmailLogin == 2 && checkPasswordLogin == 1){
            System.err.println("Tên đang nhập không đúng");
        }else {
            System.err.println("Tên đang nhập và mật khẩu không đúng");
        }

    }
}
