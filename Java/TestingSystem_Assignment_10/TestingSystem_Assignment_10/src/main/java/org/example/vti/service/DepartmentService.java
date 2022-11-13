package org.example.vti.service;

import org.example.vti.entity.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentService {
    List<Department> getListDepartments() throws SQLException;
    void addDepartment(Department requestD) throws SQLException;
    void updateDepartment(Department requestD) throws SQLException;
    void deleteDepartment(Department requestD) throws SQLException;
    void searchDepartmentID(int departmentID) throws SQLException;
    void checkDataExists(String departmentName)throws SQLException;
    void deleteDepartmentUsingProcedure(int id) throws Exception;

}
