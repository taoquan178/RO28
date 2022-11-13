package org.example.vti.repository;

import org.example.vti.entity.Department;
import org.example.vti.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

    // Khai báo đối tượng Connection để kết nối đến CSDL
    private final Connection con = DatabaseUtil.getDbIsntance().getDatabaseConnection();

    /**
     * Tương tác với database trả về danh sách Account
     *
     * @return List<Department> - Danh sách phòng ban
     * @throws SQLException - Lỗi
     */
    public List<Department> getListDepartments() throws SQLException {
        // tạo 1 list array để lưu dữ liệu vào
        List<Department> departments = new ArrayList<>();
        // Khai báo câu lệnh SQL muốn thực thi
        String sql = "SELECT * FROM `Department` ORDER BY DepartmentID";
        // B2: Khai báo đối tượng Statement tạo 1 câu lệnh gửi đến CSDL
        Statement st = con.createStatement();
        // B3: Khai báo đối tượng để nhận về kết quả thực thi của câu SQL
        // Và trả về danh sách đối tượng trong
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Department department = new Department();
            department.setId(rs.getInt(1));
            department.setName(rs.getString(2));
            departments.add(department);
        }
        return departments;
    }

    public int addDepartment(Department requestD) throws SQLException {
        String sql = "INSERT INTO `Department` (DepartmentName) VALUE (?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, requestD.getName());
        int result = ps.executeUpdate();
        con.commit();
        return result;
    }

    public int updateDepartment(Department requestD) throws SQLException {
        String sql ="UPDATE `Department` SET DepartmentName = ? WHERE DepartmentID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, requestD.getName());
        ps.setInt(2,requestD.getId());
        int result = ps.executeUpdate();
        con.commit();
        return result;
    }

    public int deleteDepartment(Department requestD) throws SQLException {
        String sql = "DELETE FROM `Department` WHERE DepartmentID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,requestD.getId());
        int result = ps.executeUpdate();
        con.commit();
        return result;
    }

    public int deleteDepartmentUsingProcedure(int id) throws SQLException{
        String sql = "CALL sp_delete_department(?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,id);
        int result = ps.executeUpdate();
        con.commit();
        return result;
    }
}
