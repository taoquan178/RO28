package org.example.service.Impl;

import org.example.entity.Employee;
import org.example.entity.Manager;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.service.IUserservice;
import org.example.util.Utils;

import java.sql.SQLException;
import java.util.List;

import static org.example.Main.*;

public class UserServiceImpl implements IUserservice {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void getListUsers() throws SQLException {
        List<User> userList = userRepository.getListUsers();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Override
    public void getUserByProjectId(int projectId) throws SQLException {
        List<Manager> managerList = userRepository.getListUsersManager();
        List<Employee> employeeList = userRepository.getListUsersEmployee();
        int a =0;
        for (Manager manager : managerList) {
            if (manager.getProjectId() == projectId){
                System.out.println(manager);
                a = 1;
            }
        }
        for (Employee employee : employeeList) {
            if (employee.getProjectId() == projectId){
                System.out.println(employee);
                a = 1;
            }
        }
        if (a !=1){
            System.err.println("Không có project id này!");
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
            System.out.println("Đăng nhập thành công!");
            menuEmployeeAndManager();
        }else if(checkEmailLogin == 1 && checkPasswordLogin == 2){
            System.err.println("Mật khẩu không đúng");
        }else if(checkEmailLogin == 2 && checkPasswordLogin == 1){
            System.err.println("Tên đang nhập không đúng");
        }else {
            System.err.println("Tên đang nhập và mật khẩu không đúng");
        }
    }

    @Override
    public void createUser(User user) throws SQLException {
        int result = userRepository.createUser(user);
        if (result>0){
            System.out.println("Thêm data user thành công!");
        }else {
            System.err.println("Thêm data user không thành công!");
        }
    }

    @Override
    public void createUserManager(User user, int projectId, int expInYear) throws SQLException {
        int result = userRepository.createUserManager(user, projectId, expInYear);
        if (result>0){
            System.out.println("Thêm data user thành công!");
        }else {
            System.err.println("Thêm data user không thành công!");
        }
    }

    @Override
    public void createUserEmployee(User user, int projectId, String proSkill) throws SQLException {
        int result = userRepository.createUserEmplyee(user,projectId,proSkill);
        if (result>0){
            System.out.println("Thêm data user thành công!");
        }else {
            System.err.println("Thêm data user không thành công!");
        }
    }
}
