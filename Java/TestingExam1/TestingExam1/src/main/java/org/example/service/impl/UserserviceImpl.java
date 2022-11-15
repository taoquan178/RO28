package org.example.service.impl;

import org.example.entity.Admin;
import org.example.entity.Employee;
import org.example.entity.User;
import org.example.utils.Utils;
import org.example.repository.UserRepository;
import org.example.service.UserService;

import java.sql.SQLException;
import java.util.List;

import static org.example.MenuAdmin.menuAdmin;
import static org.example.MenuEmployee.menuEmployee;

public class UserserviceImpl implements UserService {
    private final UserRepository userRepository;

    public UserserviceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void getListUsers() throws SQLException {
        List<User> users = userRepository.getListUsers();
        for (User user : users){
            System.out.println(user);
        }
    }

    @Override
    public void createUserAdmin(User user, Admin admin) throws Exception {
        int result = userRepository.createUser(user);
        if (result > 0){
            System.out.println("Tạo mới data user thành công");
            List<User> userList = userRepository.getList();
            int userID = Utils.getUserID(userList);
            int result1 = userRepository.createAdmin(userID,admin);
            if (result1 > 0){
                System.out.println("Tạo mới data amdin thành công");
            }else {
                throw new Exception("Tạo mới data amdin thất bại!");
            }
        }else {
            throw new Exception("Tạo mới data user thất bại!");
        }
    }

    @Override
    public void createUserEmployee(User user, Employee employee) throws Exception {
        int result = userRepository.createUser(user);
        if (result > 0){
            System.out.println("Tạo mới data user thành công");
            List<User> userList = userRepository.getList();
            int userID = Utils.getUserID(userList);
            int result1 = userRepository.createEmployee(userID,employee);
            if (result1 > 0){
                System.out.println("Tạo mới data amdin thành công");
            }else {
                throw new Exception("Tạo mới data amdin thất bại!");
            }
        }else {
            throw new Exception("Tạo mới data user thất bại!");
        }
    }

    @Override
    public void getUserByID(int userID) throws SQLException {
        List<User> userList = userRepository.getList();
        boolean checkUserID = Utils.checkUserID(userList,userID);
        if (checkUserID){
            for(User userAray : userList){
                if (userAray.getId() == userID){
                    System.out.println(userAray);
                }
            }
        }else {
            System.err.println("Không có id này!");
        }
    }

    @Override
    public void deleteUserByID(int userID) throws SQLException {
        List<User> userList = userRepository.getList();
        boolean checkUserID = Utils.checkUserID(userList,userID);
        if (checkUserID){
            int result = userRepository.deleteUserByID(userID);
            if (result > 0){
                System.out.println("Xoá data thành công");
            }else {
                System.err.println("Xoá data thất bại!");
            }
        }else {
            System.err.println("Không có id này!");
        }
    }

    @Override
    public void getList() throws SQLException {
        List<User> userList = userRepository.getList();
        for (User user : userList){
            System.out.println("ID: "+user.getId()+"- FullName: "+ user.getName() + "- Email: "+ user.getEmail());
        }
    }

    @Override
    public void login(String email,String password) throws Exception {
        List<User> userListAmin = userRepository.getListUsersAdmin();
        List<User> userListEmployee = userRepository.getListUsersEmployee();
        int checkUserEmail = Utils.checkUserEmail(userListAmin,userListEmployee,email);
        int checkUserPassword = Utils.checkUserPassword(userListAmin,userListEmployee,password);
        if (checkUserEmail == 2 && checkUserPassword == 2){
            System.out.println("Đăng nhập tài khoản admin thành công!");
            menuAdmin();
        }else if (checkUserEmail == 3 && checkUserPassword == 3){
            System.out.println("Đăng nhập tài khoản employee thành công!");
            menuEmployee();
        }
        else if(checkUserEmail == 1) {
            System.err.println("Vui lòng kiểm tra lại email!");
        }else if(checkUserPassword == 1) {
            System.err.println("Vui lòng kiểm tra lại password!");
        }else {
            System.err.println("Vui lòng kiểm tra lại email và eassword!");
        }
    }
}
