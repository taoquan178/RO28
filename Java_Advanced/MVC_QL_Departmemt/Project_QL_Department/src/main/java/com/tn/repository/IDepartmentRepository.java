package com.tn.repository;

import com.tn.entity.Account;
import com.tn.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department,Integer> {

    @Query("FROM Department WHERE name LIKE %:searchData%")
    List<Department> searchListDepartment(String searchData);
}
