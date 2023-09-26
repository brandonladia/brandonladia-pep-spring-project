package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;

@Service
public class MessageService {
    MessageRepository messageRepository;
    @Autowired
    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    //process creation of new message
    public Message postMessage(Message message){
        boolean test1;
        boolean test2;
        boolean test3; 
        return null;
    }

    //retrieve all message
    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }

    //retrieve message by id

    //delete message by id

    //update message by id

    //retrieve all messages by a particular user
    
}
