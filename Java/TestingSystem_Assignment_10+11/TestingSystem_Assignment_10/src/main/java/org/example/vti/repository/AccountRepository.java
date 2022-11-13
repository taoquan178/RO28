package org.example.vti.repository;

import org.example.vti.entity.Account;
import org.example.vti.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private final Connection con = DatabaseUtil.getDbIsntance().getDatabaseConnection();

    public List<Account> getListAccounts() throws SQLException {
        List<Account> listAccount = new ArrayList<>();
        String sql = "SELECT * FROM `Account` ORDER BY AccountID";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Account account = new Account();
            account.setId(rs.getInt(1));
            account.setEmail(rs.getString(2));
            account.setName(rs.getString(3));
            account.setFullName(rs.getString(4));
            account.setDepartment(rs.getInt(5));
            account.setPosition(rs.getInt(6));
            account.setCreateDate(rs.getDate(7));
            listAccount.add(account);
        }
        return listAccount;
    }

    public int createAccount(Account account) throws SQLException{
        String sql = "INSERT INTO `Account`(Email, Username, FullName, DepartmentID, PositionID, CreateDate)"+
                     "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,account.getEmail());
        ps.setString(2, account.getName());
        ps.setString(3,account.getFullName());
        ps.setInt(4,account.getDepartment());
        ps.setInt(5,account.getPosition());
        ps.setDate(6,account.getCreateDate() );
        int result = ps.executeUpdate();
        con.commit();
        return result;
    }

    public int updateAccount(Account account) throws SQLException{
        String sql ="UPDATE `Account` SET Email = ? , Username = ?, FullName = ?, DepartmentID= ?, PositionID = ? WHERE AccountID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,account.getEmail());
        ps.setString(2, account.getName());
        ps.setString(3,account.getFullName());
        ps.setInt(4,account.getDepartment());
        ps.setInt(5,account.getPosition());
        ps.setInt(6,account.getId());
        int result = ps.executeUpdate();
        con.commit();
        return result;
    }

    public int deleteAccount(Account account) throws SQLException {
        String sql = "DELETE FROM `Account` WHERE AccountID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,account.getId());
        int result = ps.executeUpdate();
        con.commit();
        return result;
    }
}
