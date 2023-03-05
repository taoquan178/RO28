package com.tn.service.impl;

import com.tn.dto.AccountDTO;
import com.tn.dto.DepartmentDTO;
import com.tn.entity.Account;
import com.tn.entity.Department;
import com.tn.from.FromCreateDepartment;
import com.tn.from.FromUpdateDepartment;
import com.tn.repository.IAccountRepository;
import com.tn.repository.IDepartmentRepository;
import com.tn.service.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Transactional
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private IDepartmentRepository departmentRepo;

    @Autowired
    private IAccountRepository accountRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<DepartmentDTO> getPageDepartment(Pageable pageable) {
        Page<Department> departments = departmentRepo.findAll(pageable);
        // convert sang dto
        Page<DepartmentDTO> dtoPage = departments.map(new Function<Department, DepartmentDTO>() {
            @Override
            public DepartmentDTO apply(Department entity) {
                DepartmentDTO dto = new DepartmentDTO();
                // Conversion logic
                dto.setId(entity.getId());
                dto.setName(entity.getName());
                return dto;
            }
        });
        return dtoPage;
    }

    @Override
    public List<DepartmentDTO> getAllDepartment() {
        List<Department> departments = departmentRepo.findAll();
        List<DepartmentDTO> departmentDTOs = modelMapper.map(departments,new TypeToken<List<DepartmentDTO>>(){}.getType());
        return departmentDTOs;
    }

    @Override
    public Department getDepartmentById(Integer id) {
        Department department = departmentRepo.findById(id).get();
        return department;
    }

    @Override
    public Department saveDepartment(FromCreateDepartment fromCreateDepartment) {
        Department department = modelMapper.map(fromCreateDepartment,Department.class);
        departmentRepo.save(department);
        return department;
    }

    @Override
    public void deleteDepartment(Integer id) {
        if (departmentRepo.findById(id).isPresent()){
            List<Account> accounts = accountRepo.findByDepartment(departmentRepo.getById(id));
            for(Account account : accounts){
                account.setDepartment(null);
                accountRepo.save(account);
            }
            departmentRepo.deleteById(id);
        }
    }

    @Override
    public void deleteListDepartment(List<Integer> ids) {
        for(Integer id : ids){
            if (departmentRepo.findById(id).isPresent()){
                List<Account> accounts = accountRepo.findByDepartment(departmentRepo.getById(id));
                for(Account account : accounts){
                    account.setDepartment(null);
                    accountRepo.save(account);
                }
                departmentRepo.deleteById(id);
            }
        }
//        departmentRepo.deleteByIds(ids);
    }

    @Override
    public boolean existsDepartmentName(String name) {
        return departmentRepo.existsByName(name);
    }

    @Override
    public void updateDepartment(Integer id, FromUpdateDepartment fromUpdateDepartment) {
        Department department = departmentRepo.findById(id).get();
        department.setName(fromUpdateDepartment.getName());
        departmentRepo.save(department);
    }

    @Override
    public Page<DepartmentDTO> searchListDepartment(String data,Pageable pageable) {
//        Pageable pageable = PageRequest.of(0,2);
        List<Department> departments = departmentRepo.searchListDepartment(data);
        List<DepartmentDTO> departmentDTOs = modelMapper.map(departments,new TypeToken<List<DepartmentDTO>>(){}.getType());

        // convert list to page
        final int start = (int)pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), departmentDTOs.size());
        Page<DepartmentDTO> dtoPages = new PageImpl<>(departmentDTOs.subList(start, end), pageable, departmentDTOs.size());
        return dtoPages;
    }

}
