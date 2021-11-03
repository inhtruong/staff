package com.ait.staffmanagement.service.account;

import com.ait.staffmanagement.model.Account;
import com.ait.staffmanagement.service.IGeneralService;

import java.util.Optional;

public interface IAccountService extends IGeneralService<Account> {

    Optional<Account> findByUsernameAndPassword(String username, String password);
}
