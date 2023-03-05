package com.tn.repository;

import com.tn.entity.Account;
import com.tn.entity.Department;
import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountRepository extends JpaRepository<Account,Integer> {
    List<Account> findByDepartment(Department department);

    Account findByEmail(String email);

    @Query("FROM Account WHERE name LIKE %:searchData% OR fullName LIKE %:searchData%")
    List<Account> searchListAccount(String searchData);
}
