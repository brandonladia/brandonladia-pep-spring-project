package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

@Service
public class AccountService {
    AccountRepository accountRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    //create a user
    public Account addAccount(Account account){
        boolean test1 = account.getUsername().isBlank();
        boolean test2 = account.getPassword().length() < 4;
        boolean test3;
        return accountRepository.save(account);
    }

    //verify login
    
}
