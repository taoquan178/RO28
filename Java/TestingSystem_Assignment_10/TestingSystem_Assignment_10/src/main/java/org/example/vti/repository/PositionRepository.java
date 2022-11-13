package org.example.vti.repository;

import org.example.vti.entity.Position;
import org.example.vti.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository {
    private final Connection con = DatabaseUtil.getDbIsntance().getDatabaseConnection();

    public List<Position> getListPosition() throws SQLException {
        List<Position> positionList = new  ArrayList<>();
        String sql = "SELECT * FROM `Position` ORDER BY PositionID";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()) {
            Position position = new Position();
            position.setId(rs.getInt(1));
            position.setPositionName(rs.getString(2));
            positionList.add(position);
        }
        return positionList;
    }

    public int createPosition(Position position) throws SQLException {
        String sql = "INSERT INTO `Position` (PositionName) VALUES (?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,position.getPositionName());
        int result = ps.executeUpdate();
        con.commit();
        return result;
    }

    public int updatePosition(Position position) throws SQLException {
        String sql ="UPDATE `Position` SET PositionName = ? WHERE PositionID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,position.getPositionName());
        ps.setInt(2,position.getId());
        int result = ps.executeUpdate();
        con.commit();
        return result;
    }

    public int deletePosition(Position position) throws SQLException {
        String sql ="DELETE FROM `Position` WHERE PositionID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,position.getId());
        int result = ps.executeUpdate();
        con.commit();
        return result;
    }
}
