package com.tn.service;

import com.tn.dto.AccountDTO;
import com.tn.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    Page<AccountDTO> getListAccount(Pageable pageable);

    boolean deleteAccount(Integer id);

    void saveAccount(Account account);

    void updateAccount(Account account);

    Optional<Account> updateAccount(Integer id);

    List<AccountDTO> searchListAccount(String data);

    AccountDTO getAccountByEmail(String email);
}
