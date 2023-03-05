package com.tn.service;

import com.tn.dto.AccountDTO;
import com.tn.entity.Account;
import com.tn.from.FromCreateAccount;
import com.tn.from.FromUpdateAccount;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    List<AccountDTO> getListAccount();

    String deleteAccount(Integer id);

    Account saveAccount(FromCreateAccount fromAccount);

    Account updateAccount(Integer id,FromUpdateAccount fromAccount);

    List<AccountDTO> searchListAccount(String data);

    AccountDTO getAccountByEmail(String email);
}
