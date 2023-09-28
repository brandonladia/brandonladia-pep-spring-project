package com.example.service;

import java.util.Optional;

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
        boolean test1 = account.getUsername().isBlank(); //valid
        boolean test2 = account.getPassword().length() < 4; //valid
        boolean test3 = accountRepository.findAccountByUsername(account.getUsername()).isPresent(); //valid
        if(test1 || test2){
            return null;
        } else if(test3) {
            return null;
        } else {
            return accountRepository.save(account);
        }
    }

    //verify login
    public Account verifyLogin(Account account){
        return account;
    }
    
}
