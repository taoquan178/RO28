package com.tn.dto;

import com.tn.entity.Account;
import lombok.Data;

@Data
public class AccountDTO {
    private Integer id;

    private String name;

    private String fullName;

    private Account.Type type;

    private String email;

    private String departmentName;

    public enum Type{
        EMPLOYEE,ADMIN
    }
}
