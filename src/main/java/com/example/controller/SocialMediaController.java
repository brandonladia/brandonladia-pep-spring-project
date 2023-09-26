package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.service.AccountService;
import com.example.service.MessageService;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
 
//added @RestController
@RestController
public class SocialMediaController {

    @Autowired
    AccountService accountService;

    @Autowired
    MessageService messageService;

    //POST  /register
    @PostMapping("/register")
    public ResponseEntity<Account> newAccount(@RequestBody Account account){
        return null;
    }

    //POST  /login
    @PostMapping("/login")
    public ResponseEntity<Account> registerLogin(){
        return null;
    }

    //POST  /messages
    @PostMapping("/messages")
    public ResponseEntity<Message> newMessage(){
        return null;
    }

    //GET   /messages
    @GetMapping("/messages")
    public List<Message> getAllMessages(){
        return messageService.getAllMessages();
    }

    //GET by id     /messages/{message_id}
    @GetMapping("/messages/{message_id}")
    public ResponseEntity<Message> getMessageById(){
        return null;
    }

    //DELETE by id  /messages/{message_id}
    @DeleteMapping("/messages/{message_id}")
    public ResponseEntity<Integer> deleteMessageById(){
        return null;
    }

    //PATCH by id  /messages/{message_id}
    @PatchMapping("/messages/{message_id}")
    public ResponseEntity<Message> patchMessageById(){
        return null;
    }

    //GET by account id /accounts/{account_id}/messages
    @GetMapping("/accounts/{account_id}/messages")
    public List<Message> getMessagebyUserId(){
        return null;
    }

}
