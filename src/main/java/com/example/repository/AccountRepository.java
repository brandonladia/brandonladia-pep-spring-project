package com.example.repository;

import org.springframework.stereotype.Repository;

//what "account" table looks like
// account_id integer primary key auto_increment,
// username varchar(255) not null unique,
// password varchar(255)

//added Repository
@Repository
public interface AccountRepository {

    //create a user

    //verify login

}
