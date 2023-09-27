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
        boolean test1 = message.getMessage_text().isBlank(); //valid
        boolean test2 = message.getMessage_text().length() >= 255; //valid
        boolean test3 = message.getPosted_by() == null; //issue
        if(test1 || test2){
            return null;
        } else {
            return messageRepository.save(message);
        }
    }

    //retrieve all message
    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }

    //retrieve message by id
    public Message getMessageById(int messageId){
        messageRepository.getById(messageId);
        return null;
    }

    //delete message by id

    //update message by id

    //retrieve all messages by a particular user
    
}
