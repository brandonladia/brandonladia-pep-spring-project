package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Account;

//what "account" table looks like
// account_id integer primary key auto_increment,
// username varchar(255) not null unique,
// password varchar(255)

//added Repository
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    //create a user
    Optional<Account> findByUsername(String username);
    //verify login
    Optional<Account> findByUsernameAndPassword(String username, String password);

}
