package com.tn.service.impl;

import com.tn.dto.DepartmentDTO;
import com.tn.entity.Account;
import com.tn.entity.Department;
import com.tn.repository.IAccountRepository;
import com.tn.repository.IDepartmentRepository;
import com.tn.service.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private IDepartmentRepository departmentRepo;

    @Autowired
    private IAccountRepository accountRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DepartmentDTO> getListDepartment() {
        List<Department> departments = departmentRepo.findAll();
        List<DepartmentDTO> departmentDTOs = modelMapper.map(departments,new TypeToken<List<DepartmentDTO>>(){}.getType());
        return departmentDTOs;
    }

    @Override
    public void saveDepartment(Department department) {
        departmentRepo.save(department);
    }

    @Override
    public boolean deleteDepartment(Integer id) {
        if (!departmentRepo.findById(id).isPresent()){
            return false;
        }
        List<Account> accounts = accountRepo.findByDepartment(departmentRepo.getById(id));
        for(Account account : accounts){
            account.setDepartment(null);
            accountRepo.save(account);
        }
        departmentRepo.deleteById(id);
        return true;
    }

    @Override
    public Optional<Department> updateDepartment(Integer id) {
        Optional<Department> department = departmentRepo.findById(id);
        return department;
    }

    @Override
    public List<DepartmentDTO> searchListDepartment(String data) {
        List<Department> departments = departmentRepo.searchListDepartment(data);
        List<DepartmentDTO> departmentDTOs = modelMapper.map(departments,new TypeToken<List<DepartmentDTO>>(){}.getType());
        return departmentDTOs;
    }
}
