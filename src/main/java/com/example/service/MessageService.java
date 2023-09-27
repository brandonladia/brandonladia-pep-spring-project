package com.example.service;

import java.util.List;
import java.util.Optional;

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
        Optional<Message> message = messageRepository.findById(messageId);
        if(message.isPresent()){
            return message.get();
        } else {
            return null;
        }
    }

    //delete message by id
    public int deleteMessageById(int messageId){
        return 0;
    }
    //build out
    
    //update message by id

    //retrieve all messages by a particular user
    
}
