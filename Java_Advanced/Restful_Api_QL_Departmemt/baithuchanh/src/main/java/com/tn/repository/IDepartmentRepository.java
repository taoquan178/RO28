package com.tn.repository;

import com.tn.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department,Integer> {

    @Query("FROM Department WHERE name LIKE %:searchData%")
    List<Department> searchListDepartment(String searchData);

    boolean existsByName(String name);

    // import của springframework
    @Modifying
    @Transactional
    @Query("DELETE FROM Department WHERE id IN(:ids)")
    public void deleteByIds(@Param("ids") List<Integer> ids);
}
