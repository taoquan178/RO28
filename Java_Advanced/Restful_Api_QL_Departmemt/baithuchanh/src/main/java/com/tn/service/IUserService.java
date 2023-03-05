package com.tn.service;

import com.tn.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    Account getAccountByUsername(String username);
}
