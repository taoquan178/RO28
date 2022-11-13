package org.example.vti.controller;

import org.example.vti.entity.Department;
import org.example.vti.service.DepartmentService;

import java.util.ArrayList;
import java.util.List;

public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public List<Department> getListDepartment(){
        List<Department> departments = new ArrayList<>();
        try {
            departments = departmentService.getListDepartments();
        }catch ( Exception e){
            System.err.println("Lấy danh sách department không thành công " + e.getMessage());
        }
        return departments;
    }

    public void addDepartment(Department requestD){
        try {
            departmentService.addDepartment(requestD);
        }catch ( Exception e){
            System.err.println("Tạo department không thành công " + e.getMessage());
        }
    }

    public void updateDepartment(Department requestDUpdate){
        try {
            departmentService.updateDepartment(requestDUpdate);
        }catch ( Exception e){
            System.err.println("Cập nhập department không thành công " + e.getMessage());
        }
    }

    public void deleteDepartment(Department requestDDelete){
        try {
            departmentService.deleteDepartment(requestDDelete);
        }catch ( Exception e ){
            System.err.println("Xoá department không thành công " + e.getMessage());
        }
    }

    public void searchDepartmentID(int departmentID){
        try {
            departmentService.searchDepartmentID(departmentID);
        }catch ( Exception e ){
            System.err.println("Tìm id department không thành công " + e.getMessage());
        }
    }

    public void checkDataExists(String departmentName){
        try {
            departmentService.checkDataExists(departmentName);
        }catch ( Exception e ){
            System.err.println("Kiểm tra tên department không thành công " + e.getMessage());
        }
    }

    public void deleteDepartmentUsingProcedure(int id){
        try {
            departmentService.deleteDepartmentUsingProcedure(id);
        }catch ( Exception e ){
            System.err.println("Xoá department không thành công " + e.getMessage());
        }
    }
}
