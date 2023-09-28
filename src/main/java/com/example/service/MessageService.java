package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    @Autowired
    AccountRepository accountRepository;
    
    @Autowired
    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    //process creation of new message
    public Message postMessage(Message message){
        if (message.getMessage_text() == null || message.getMessage_text().trim().isEmpty() || message.getMessage_text() .length() > 255) {
            return null;
        }
        if (accountRepository.findById(message.getPosted_by()).isEmpty()) {
            return null;
        }
        return messageRepository.save(message);
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
        messageRepository.deleteById(messageId);
        return 1;
    }

    //update message by id
    public Message updateMessageById(Message message){
        boolean test1 = messageRepository.existsById(message.getMessage_id());
        boolean test2 = message.getMessage_text().equals(""); //valid
        boolean test3 = message.getMessage_text().length() > 255; //valid
        if(test1 && test2 && test3){
            return null;
        } else {
            return messageRepository.save(message);
        }
    }

    //retrieve all messages by a particular user
    public List<Message> getAllMessagesByUserId(int postedBy){
        return messageRepository.findMessagesPostedBy(postedBy);
    }
    
}
