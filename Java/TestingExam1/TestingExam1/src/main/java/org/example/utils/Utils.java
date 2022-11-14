package org.example.utils;

import org.example.entity.User;

import java.util.List;
import java.util.regex.Pattern;

public class Utils {
    public static int getUserID(List<User> userList){
        for (int i = 0; i < userList.size(); i++) {
            if(i == (userList.size() -1)){
                return i+1;
            }
        }
        return 0;
    }

    public static boolean checkUserID(List<User> userList, int id){
        for(User userAray : userList){
            if (userAray.getId() == id){
                return true;
            }
        }
        return false;
    }

    public static boolean checkUserEmail(List<User> userList, String email){
        for(User userAray : userList){
            if (userAray.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkUserPassword(List<User> userList, String password){
        if (Pattern.matches("[a-zA-Z0-9_-]{6,12}$", password)){
            for(User userAray : userList){
                if (userAray.getPassword().equals(password)){
                    return true;
                }
            }
        }else {
            System.err.println("Password không đúng định dạng!");
        }
        return false;
    }
}
