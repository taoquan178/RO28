package com.tn.service;

import com.tn.dto.DepartmentDTO;
import com.tn.entity.Department;
import com.tn.from.FromCreateDepartment;
import com.tn.from.FromUpdateDepartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IDepartmentService {

    Page<DepartmentDTO> getPageDepartment(Pageable pageable);

    List<DepartmentDTO> getAllDepartment();

    Department getDepartmentById(Integer id);

    Department saveDepartment(FromCreateDepartment fromCreateDepartment);

    void deleteDepartment(Integer id);

    void deleteListDepartment(List<Integer> ids);

    boolean existsDepartmentName(String name);

    void updateDepartment(Integer id, FromUpdateDepartment fromUpdateDepartment);

    Page<DepartmentDTO> searchListDepartment(String data,Pageable pageable);

}
