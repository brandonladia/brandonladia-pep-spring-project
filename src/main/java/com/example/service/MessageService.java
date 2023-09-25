package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.MessageRepository;

@Service
public class MessageService {
    MessageRepository messageRepository;
    @Autowired
    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    //process creation of new message

    //retrieve all message

    //retrieve message by id

    //delete message by id

    //update message by id

    //retrieve all messages by a particular user
    
}
