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

    @Query("FROM account WHERE username = :username")
    Account findByUsername(@Param("username") String username);

}
