package com.tn.dto;

import com.tn.entity.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginInfoDTO {

    private Integer id;

    private String name;

    private String fullName;

    private Account.Type type;

    private String email;
}
