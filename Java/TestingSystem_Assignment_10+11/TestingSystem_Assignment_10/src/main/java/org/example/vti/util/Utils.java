package org.example.vti.util;

import org.apache.commons.lang3.StringUtils;
import org.example.vti.entity.Account;
import org.example.vti.entity.Department;
import org.example.vti.entity.Position;
import org.example.vti.repository.DepartmentRepository;
import org.example.vti.repository.PositionRepository;

import java.sql.SQLException;
import java.util.List;

public class Utils {
    public static boolean validateDepartment(String action, Department department){
        if (action.equalsIgnoreCase("add")){
            //trả về true khi department.getName() không phải là giá trị null
            return !StringUtils.isBlank(department.getName());
        } else if (action.equalsIgnoreCase("update")) {
            if (department.getId() == null){
                return false;
            }else {
                return !StringUtils.isBlank(department.getName());
            }
        } else if (action.equalsIgnoreCase("delete")) {
            return department.getId() != null;
        }
        return true;
    }

    public static boolean validatePosition(List<Position> positionList, Position position){
        for (Position position1 : positionList){
            if (position1.getId() == position.getId()){
                return true;
            }
        }
        return false;
    }

    public static boolean validateDepartment(List<Department> departmentList, int id){
        for (Department department1 : departmentList){
            if (department1.getId() == id){
                return true;
            }
        }
        return false;
    }

    public static boolean validateAccount(List<Account> accountList, Account account){
        for (Account accountArry : accountList){
            if (accountArry.getId() == account.getId()){
                return true;
            }
        }
        return false;
    }

}
