package com.tn.service;

import com.tn.dto.DepartmentDTO;
import com.tn.entity.Department;

import java.util.List;
import java.util.Optional;

public interface IDepartmentService {

    List<DepartmentDTO> getListDepartment();

    void saveDepartment(Department department);

    boolean deleteDepartment(Integer id);

    Optional<Department> updateDepartment(Integer id);

    List<DepartmentDTO> searchListDepartment(String data);
}
