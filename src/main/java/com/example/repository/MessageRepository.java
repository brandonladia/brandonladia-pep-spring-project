package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Message;

//what "message" table looks like
// message_id integer primary key auto_increment,
// posted_by integer,
// message_text varchar(255),
// time_posted_epoch long,
// foreign key (posted_by) references Account(account_id)

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    List<Message> findMessagesByPostedBy(Integer posted_by);
    
}
