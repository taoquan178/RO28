package com.tn.from;

import lombok.Data;

@Data
public class FromCreateAccount {
    private Integer id;

    private String name;

    private String fullName;

    private FromCreateAccount.Type type;

    private String email;

    private String password;

    private Integer departmentId;

    public enum Type{
        EMPLOYEE,MANAGER,ADMIN
    }
}
