package com.tn.service.impl;

import com.tn.entity.Account;
import com.tn.repository.IAccountRepository;
import com.tn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IAccountRepository accountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepo.findByEmail(username);
        if (account == null) {
            throw new UsernameNotFoundException("Could not find account");
        }
        return new User(
                account.getEmail(),
                account.getPassword(),
                AuthorityUtils.createAuthorityList(account.getType().toString()));
    }

    @Override
    public Account getAccountByUsername(String username) {
        return accountRepo.findByEmail(username);
    }
}
