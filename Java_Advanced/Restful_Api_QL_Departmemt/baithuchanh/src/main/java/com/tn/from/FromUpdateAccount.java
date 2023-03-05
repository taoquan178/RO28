package com.tn.from;

import com.tn.entity.Account;
import lombok.Data;

@Data
public class FromUpdateAccount {

    private String name;

    private String fullName;

    private Account.Type type;

    private Integer departmentId;

}
