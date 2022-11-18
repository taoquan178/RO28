package org.example.repository;

import org.example.entity.Admin;
import org.example.entity.Employee;
import org.example.entity.Manager;
import org.example.entity.User;
import org.example.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final Connection con = DatabaseUtil.getDbIsntance().getDatabaseConnection();

    public List<User> getListUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM `User` ORDER BY `UserID`";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            if (rs.getString("TypeUser").equals("Admin")){
                Admin admin = new Admin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5));
                userList.add(admin);
            }else if (rs.getString("TypeUser").equals("Employee")){
                Employee employee = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5),rs.getInt(8),rs.getString(7));
                userList.add(employee);
            }else if (rs.getString("TypeUser").equals("Manager")){
                Manager manager = new Manager(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5),rs.getInt(6),rs.getInt(8));
                userList.add(manager);
            }
        }
        return userList;
    }

    public int createUser(User user) throws SQLException {
        String  sql = "INSERT INTO `User` (`FullName`, `Email`, `Password`, `TypeUser`) VALUE (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,user.getFullName());
        ps.setString(2,user.getEmail());
        ps.setString(3,user.getPassword());
        ps.setString(4,user.getTypeUser());
        int result = ps.executeUpdate();
        con.commit();
        return result;
    }

    public int createUserEmplyee(User user, int projectId, String proSkill) throws SQLException {
        String  sql = "INSERT INTO `User` (`FullName`, `Email`, `Password`, `TypeUser`, `ProSkill`,`ProjectID`) VALUE (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,user.getFullName());
        ps.setString(2,user.getEmail());
        ps.setString(3,user.getPassword());
        ps.setString(4,user.getTypeUser());
        ps.setString(5,proSkill);
        ps.setInt(6,projectId);
        int result = ps.executeUpdate();
        con.commit();
        return result;
    }

    public int createUserManager(User user, int projectId, int expInYear) throws SQLException {
        String  sql = "INSERT INTO `User` (`FullName`, `Email`, `Password`, `TypeUser`, `ExpInYear`, `ProjectID`) VALUE (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,user.getFullName());
        ps.setString(2,user.getEmail());
        ps.setString(3,user.getPassword());
        ps.setString(4,user.getTypeUser());
        ps.setInt(5,expInYear);
        ps.setInt(6,projectId);
        int result = ps.executeUpdate();
        con.commit();
        return result;
    }

    public List<Manager> getListUsersManager() throws SQLException {
        List<Manager> managerList = new ArrayList<>();
        String sql = "SELECT * FROM `User` ORDER BY `UserID`";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            if (rs.getString("TypeUser").equals("Manager")){
                Manager manager = new Manager(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5),rs.getInt(6),rs.getInt(8));
                managerList.add(manager);
            }
        }
        return managerList;
    }
    public List<Employee> getListUsersEmployee() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT * FROM `User` ORDER BY `UserID`";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            if (rs.getString("TypeUser").equals("Employee")){
                Employee employee = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5),rs.getInt(8),rs.getString(7));
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

}
