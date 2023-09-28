package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

@Service
public class AccountService {
    
    @Autowired
    AccountRepository accountRepository;
    
    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    //create a user
    public Account addAccount(Account account){
        if (account.getUsername() == null || account.getUsername().trim().isEmpty()) {
            return null;
        }
        if (account.getPassword() == null || account.getPassword().length() < 4) {
            return null;
        }
        if (accountRepository.findByUsername(account.getUsername()) != null) {
            return null;
        }
        return accountRepository.save(account);
    }
    

    public boolean isUsernameDuplicate(String username){
        return accountRepository.findByUsername(username) != null;
    }

    //verify login
    public Account verifyLogin(String username, String password){
        Account loggedAccount = accountRepository.findByUsername(username);
        if (loggedAccount != null && password.equals(loggedAccount.getPassword())) {
            return loggedAccount;
        }
        return null;
    }
    
}
