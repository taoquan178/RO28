package org.example.repository;

import org.example.entity.Admin;
import org.example.entity.Employee;
import org.example.entity.User;
import org.example.utils.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final Connection con = DatabaseUtil.getDbIsntance().getDatabaseConnection();

    public List<User> getListUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM `User` T1 JOIN `Admin` T2 ON T1.UserID = T2.UserID ORDER BY T1.UserID";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Admin admin = new Admin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
            userList.add(admin);
        }

        String sql1 = "SELECT * FROM `User` T1 JOIN `Employee` T2 ON T1.UserID = T2.UserID ORDER BY T1.UserID";
        Statement st1 = con.createStatement();
        ResultSet rs1 = st1.executeQuery(sql1);
        while (rs1.next()) {
            Employee employee = new Employee(rs1.getInt(1),rs1.getString(2),rs1.getString(3),rs1.getString(4), rs1.getString(5));
            userList.add(employee);
        }
        return userList;
    }

    public List<User> getList() throws SQLException {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM `User` ORDER BY UserID";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
           User user = new User();
           user.setId(rs.getInt(1));
           user.setName(rs.getString(2));
           user.setEmail(rs.getString(3));
           user.setPassword(rs.getString(4));
           userList.add(user);
        }
        return userList;
    }

    public int createUser(User user) throws SQLException {
        String sql = "INSERT INTO `User`(FullName, Email, `Password`) VALUE (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,user.getName());
        ps.setString(2,user.getEmail());
        ps.setString(3,user.getPassword());
        int Result = ps.executeUpdate();
        con.commit();
        return Result;
    }

    public int createAdmin(int userID, Admin admin) throws SQLException {
        String sql = "INSERT INTO `Admin`(ExpInYear, UserID) VALUE (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,admin.getExpInYear());
        ps.setInt(2,userID);
        int Result = ps.executeUpdate();
        con.commit();
        return Result;
    }

    public int createEmployee(int userID, Employee employee) throws SQLException {
        String sql = "INSERT INTO `Employee` (ProSkill, UserID) VALUE (?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,employee.getProSkill());
        ps.setInt(2,userID);
        int Result = ps.executeUpdate();
        con.commit();
        return Result;
    }

    public int deleteUserByID(int id) throws SQLException {
        String sql = "DELETE FROM `User` WHERE UserID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,id);
        int Result = ps.executeUpdate();
        con.commit();
        return Result;
    }

    public List<User> getListUsersAdmin() throws SQLException {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM `User` T1 JOIN `Admin` T2 ON T1.UserID = T2.UserID ORDER BY T1.UserID";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Admin admin = new Admin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
            userList.add(admin);
        }
        return userList;
    }

    public List<User> getListUsersEmployee() throws SQLException {
        List<User> userList = new ArrayList<>();
        String sql1 = "SELECT * FROM `User` T1 JOIN `Employee` T2 ON T1.UserID = T2.UserID ORDER BY T1.UserID";
        Statement st1 = con.createStatement();
        ResultSet rs1 = st1.executeQuery(sql1);
        while (rs1.next()) {
            Employee employee = new Employee(rs1.getInt(1),rs1.getString(2),rs1.getString(3),rs1.getString(4), rs1.getString(5));
            userList.add(employee);
        }
        return userList;
    }
}
