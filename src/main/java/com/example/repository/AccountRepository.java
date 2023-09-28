package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Account;

//what "account" table looks like
// account_id integer primary key auto_increment,
// username varchar(255) not null unique,
// password varchar(255)

//added Repository
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    //@Query(value = "SELECT * FROM account WHERE username = ?", nativeQuery = true)
    Account findByUsername(String username);

    @Query(value = "SELECT * FROM account WHERE password = ?", nativeQuery = true)
    Optional<Account> findAccountByPassword(String password);

    @Query(value = "SELECT * FROM account where username = ? AND password = ?", nativeQuery = true)
    Optional<Account> findUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    //may switch to Optional<Account>

}
