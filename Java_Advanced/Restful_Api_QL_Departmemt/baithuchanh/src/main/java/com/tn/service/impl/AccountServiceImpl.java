package com.tn.service.impl;

import com.tn.dto.AccountDTO;
import com.tn.entity.Account;
import com.tn.from.FromCreateAccount;
import com.tn.from.FromUpdateAccount;
import com.tn.repository.IAccountRepository;
import com.tn.repository.IDepartmentRepository;
import com.tn.service.IAccountService;
import com.tn.service.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountRepository accountRepo;

    @Autowired
    private IDepartmentRepository departmentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AccountDTO> getListAccount() {
        List<Account> accounts = accountRepo.findAll();
        List<AccountDTO> accountDto = modelMapper.map(accounts, new TypeToken<List<AccountDTO>>(){}.getType());
        return accountDto;
    }

    @Override
    public String deleteAccount(Integer id) {
        if (!accountRepo.findById(id).isPresent()){
            return "Xoá thất bại, account không tồn tại!";
        }
        accountRepo.deleteById(id);
        return "Xoá thành công!";
    }

    @Override
    public Account saveAccount(FromCreateAccount fromAccount) {
        Account account = modelMapper.map(fromAccount,Account.class);
        if (fromAccount.getDepartmentId() != null){
            account.setDepartment(departmentRepo.findById(fromAccount.getDepartmentId()).get());
        }
        String password = new BCryptPasswordEncoder().encode(fromAccount.getPassword());
        account.setPassword(password);
        accountRepo.save(account);
        return account;
    }

    @Override
    public Account updateAccount(Integer id,FromUpdateAccount fromAccount) {
        Account account = accountRepo.findById(id).get();
        account.setName(fromAccount.getName());
        account.setFullName(fromAccount.getFullName());
        account.setType(fromAccount.getType());
        if (fromAccount.getDepartmentId() != null) {
            account.setDepartment(departmentRepo.findById(fromAccount.getDepartmentId()).get());
        }
        accountRepo.save(account);
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
