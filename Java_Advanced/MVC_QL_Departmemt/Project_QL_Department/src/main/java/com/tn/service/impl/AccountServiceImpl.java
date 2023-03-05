package com.tn.service.impl;

import  com.tn.dto.AccountDTO;
import com.tn.entity.Account;
import com.tn.repository.IAccountRepository;
import com.tn.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountRepository accountRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<AccountDTO> getListAccount(Pageable pageable) {
//        Pageable pageable = PageRequest.of(1,3);
        Page<Account> accounts = accountRepo.findAll(pageable);
        List<AccountDTO> accountDto = modelMapper.map(accounts.getContent(), new TypeToken<List<AccountDTO>>(){}.getType());
        Page<AccountDTO> dtoPages = new PageImpl<>(accountDto, pageable, accounts.getTotalElements());

        return dtoPages;
    }

    @Override
    public boolean deleteAccount(Integer id) {
        if (!accountRepo.findById(id).isPresent()){
            return false;
        }
        accountRepo.deleteById(id);
        return true;
    }

    @Override
    public void saveAccount(Account account) {
        account.setPassword(new BCryptPasswordEncoder().encode(account.getPassword()));
        accountRepo.save(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountRepo.save(account);
    }

    @Override
    public Optional<Account> updateAccount(Integer id) {
        Optional<Account> account = accountRepo.findById(id);
        return account;
    }

    @Override
    public List<AccountDTO> searchListAccount(String data) {
        List<Account> accounts = accountRepo.searchListAccount(data);
        List<AccountDTO> accountDto = modelMapper.map(accounts, new TypeToken<List<AccountDTO>>(){}.getType());
        return accountDto;
    }

    @Override
    public AccountDTO getAccountByEmail(String email) {
        Account account = accountRepo.findByEmail(email);
        AccountDTO accountDTO = modelMapper.map(account,AccountDTO.class);
        return accountDTO;
    }
}
