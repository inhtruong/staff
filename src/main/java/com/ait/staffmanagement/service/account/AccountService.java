package com.ait.staffmanagement.service.account;

import com.ait.staffmanagement.model.Account;
import com.ait.staffmanagement.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteById(long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Optional<Account> findByUsernameAndPassword(String username, String password) {
        return accountRepository.findByUsernameAndPassword(username, password);
    }
}
