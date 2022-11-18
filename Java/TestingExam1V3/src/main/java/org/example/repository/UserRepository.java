package org.example.repository;

import org.example.entity.Admin;
import org.example.entity.Employee;
import org.example.entity.User;
import org.example.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final Connection con = DatabaseUtil.getDbIsntance().getDatabaseConnection();

    public List<User> getListUsers() throws SQLException {
        List<User> usersList = new ArrayList<>();
        String sql = "SELECT * FROM `User` ORDER BY `UserID`";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            if (rs.getString("TypeUser").equals("Admin")){
                Admin admin = new Admin(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6));
                usersList.add(admin);
            }else if (rs.getString("TypeUser").equals("Employee")){
                Employee employee = new Employee(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(7));
                usersList.add(employee);
            }
        }
        return usersList;
    }

    public int deleteUserById(int userId) throws SQLException {
        String sql = "DELETE FROM `User` WHERE `UserID` = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,userId);
        int result = ps.executeUpdate();
        con.commit();
        return result;
    }

    public int createUser(User user, String expInYear, String proSkill) throws SQLException {
        String sql = "INSERT INTO `User` (`UserFullName`,`Email`,`Password`,`TypeUser`,`ExpInYear`,`ProSkill`) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,user.getFullname());
        ps.setString(2,user.getEmail());
        ps.setString(3,user.getPassword());
        ps.setString(4,user.getTypeUser());
        ps.setString(5,expInYear);
        ps.setString(6,proSkill);
        int result = ps.executeUpdate();
        con.commit();
        return result;
    }

}
