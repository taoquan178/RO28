package org.example.util;

import org.example.entity.User;
import java.util.List;

public class Utils {
    public static int checkEmailLogin(List<User> userList, String email){
        for (User user : userList) {
            if (user.getEmail().equals(email)){
                if (user.getTypeUser().equals("Admin")){
                    return 1;
                } else if (user.getTypeUser().equals("Employee") || user.getTypeUser().equals("Manager")){
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
                } else if (user.getTypeUser().equals("Employee") || user.getTypeUser().equals("Manager")){
                    return 2;
                }
            }
        }
        return 0;
    }
}
