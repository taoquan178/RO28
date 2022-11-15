package org.example.utils;

import org.example.entity.User;

import java.util.List;

public class Utils {
    public static int getUserID(List<User> userList){
        for (int i = 0; i < userList.size(); i++) {
            if(i == (userList.size() -1)){
                return userList.get(i).getId();
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

    public static int checkUserEmail(List<User> userListAdmin, List<User> userListEmployee, String email){
        for(User userAray : userListAdmin){
            if (userAray.getEmail().equals(email)){
                return 2;
            }
        }
        for(User userAray : userListEmployee){
            if (userAray.getEmail().equals(email)){
                return 3;
            }
        }
        return 1;
    }

    public static int checkUserPassword(List<User> userListAdmin, List<User> userListEmployee, String password){
            for(User userAray : userListAdmin){
                if (userAray.getPassword().equals(password)){
                    return 2;
                }
            }
        for(User userAray : userListEmployee){
            if (userAray.getPassword().equals(password)){
                return 3;
            }
        }
        return 1;
    }
}
