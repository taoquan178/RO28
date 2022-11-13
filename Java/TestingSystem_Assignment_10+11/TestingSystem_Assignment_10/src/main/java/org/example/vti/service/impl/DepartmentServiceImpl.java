package org.example.vti.service.impl;

import org.example.vti.entity.Department;
import org.example.vti.repository.DepartmentRepository;
import org.example.vti.service.DepartmentService;
import org.example.vti.util.Utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository deparementRepository;

    public DepartmentServiceImpl(DepartmentRepository deparementRepository) {
        this.deparementRepository = deparementRepository;
    }

    @Override
    public List<Department> getListDepartments() throws SQLException {
        return deparementRepository.getListDepartments();
    }

    @Override
    public void addDepartment(Department requestD) throws SQLException {
        int result =  deparementRepository.addDepartment(requestD);
        if (result > 0){
            System.out.println("Tạo data department thành công!");
        }else {
            System.err.println("Tạo data department thất bại!");
        }
    }

    @Override
    public void updateDepartment(Department requestD) throws SQLException {
        boolean validate = Utils.validateDepartment("update",requestD);
        if (validate){
            int result =  deparementRepository.updateDepartment(requestD);
            if (result > 0){
                System.out.println("Cập nhập data department thành công!");
            }else {
                throw new RuntimeException("Cập nhập data department thất bại!");
            }
        }else {
            throw new RuntimeException("Dữ liệu nhập vào không đúng. Vui lòng kiểm tra lại!");
        }
    }

    @Override
    public void deleteDepartment(Department requestD) throws SQLException {
        boolean validate = Utils.validateDepartment("delete",requestD);
        if (validate){
            int result =  deparementRepository.deleteDepartment(requestD);
            if (result > 0){
                System.out.println("Xoá data department thành công!");
            }else {
                throw new RuntimeException("Xoá data department thất bại!");
            }
        }else {
            throw new RuntimeException("Dữ liệu nhập vào không đúng. Vui lòng kiểm tra lại!");
        }
    }

    @Override
    public void searchDepartmentID(int departmentID) throws SQLException {
        List<Department> departmentList = getListDepartments();
        boolean a = false;
        for (Department departmentaray : departmentList){
            if (departmentaray.getId() == departmentID){
                a = true;
                System.out.println(departmentaray);
            }
        }
        if (!a){
            System.err.println("Cannot find department which has id = "+ departmentID );
        }
    }

    @Override
    public void checkDataExists(String departmentName) throws SQLException {
        List<Department> departmentList = getListDepartments();
        boolean a = false;
        for (Department departmentaray : departmentList){
            if (departmentaray.getName().equalsIgnoreCase(departmentName)){
                a = true;
            }
        }
        System.out.println(a);
    }

    @Override
    public void deleteDepartmentUsingProcedure(int id) throws Exception {
        List<Department> departmentList = getListDepartments();
        boolean validate = Utils.validateDepartment(departmentList,id);
        if (validate){
            int result =  deparementRepository.deleteDepartmentUsingProcedure(id);
            if (result > 0){
                System.out.println("Xoá data department thành công!");
            }else {
                throw new RuntimeException("Xoá data department thất bại!");
            }
        }else {
            throw new Exception("Cannot find department which has id = "+ id);
        }
    }
}
