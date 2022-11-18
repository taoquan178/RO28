package org.example.util;

import org.example.entity.User;

import java.util.List;

public class Utils {
    public static boolean checkUserId(List<User> userList, int userId) {
        for (User user : userList) {
            if(user.getId() == userId) {
                return true;
            }
        }
        return false;
    }

    public static int checkEmailLogin(List<User> userList, String email){
        for (User user : userList) {
            if (user.getEmail().equals(email)){
                if (user.getTypeUser().equals("Admin")){
                    return 1;
                } else if (user.getTypeUser().equals("Employee")){
                    return 2;
                }
            }
        }
        return 0;
    }

    public static int checkPasswordLogin(List<User> userList, String password){
        for (User user : userList) {
            if (user.getPassword().equals(password)){
                if (user.getTypeUser().equals("Admin")){
                    return 1;
                } else if (user.getTypeUser().equals("Employee")){
                    return 2;
                }
            }
        }
        return 0;
    }
}
