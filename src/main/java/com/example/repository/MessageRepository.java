package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    
    @Query(value = "SELECT * FROM message WHERE posted_by = ?", nativeQuery = true)
    List<Message> findMessagesPostedBy(Integer posted_by);

}
