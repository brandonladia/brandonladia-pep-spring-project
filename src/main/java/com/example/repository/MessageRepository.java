package com.example.repository;

import org.springframework.stereotype.Repository;

//what "message" table looks like
// message_id integer primary key auto_increment,
// posted_by integer,
// message_text varchar(255),
// time_posted_epoch long,
// foreign key (posted_by) references Account(account_id)

@Repository
public interface MessageRepository {

    //process creation of new message

    //retrieve all message

    //retrieve message by id

    //delete message by id

    //update message by id

    //retrieve all messages by a particular user
    
}
