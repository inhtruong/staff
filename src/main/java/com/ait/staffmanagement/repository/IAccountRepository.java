package com.ait.staffmanagement.repository;

import com.ait.staffmanagement.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUsernameAndPassword(String username, String password);
}
