package com.example.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        Account checkAccount = accountService.addAccount(account);
        if(checkAccount == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }
    //ResponseEntity.status(HttpStatus.CONFLICT).build();       409
    //ResponseEntity.status(HttpStatus.BAD_REQUEST).build();    400
    //work more on

    //POST  /login
    @GetMapping("/login")
    public ResponseEntity<Account> registerLogin(@RequestBody Account account){
        Account loggedIn = accountService.verifyLogin(account);
        if(loggedIn == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }

    //POST  /messages
    @PostMapping("/messages")
    public ResponseEntity<Message> newMessage(@RequestBody Message message){
        Message postMessage = messageService.postMessage(message);
        if(postMessage == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity.ok(postMessage);
        }
    }
    //in progress

    //GET   /messages
    @GetMapping("/messages")
    public List<Message> getAllMessages(){
        return messageService.getAllMessages();
    }
    //completed

    //GET by id     /messages/{message_id}
    @GetMapping("/messages/{message_id}")
    public ResponseEntity<Message> getMessageById(@PathVariable("message_id") int messageId){
        Message message = messageService.getMessageById(messageId);
        return ResponseEntity.ok(message);
    }
    //completed

    //DELETE by id  /messages/{message_id}
    @DeleteMapping("/messages/{message_id}")
    public ResponseEntity<Integer> deleteMessageById(@PathVariable("message_id") int messageId){
        return null;
    }

    //PATCH by id  /messages/{message_id}
    @PatchMapping("/messages/{message_id}")
    public ResponseEntity<?> patchMessageById(@PathVariable("message_id") Message message){
        Message messages = messageService.updateMessageById(message);
        if(messages == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity.ok(1);
        }
    }

    //GET by account id /accounts/{account_id}/messages
    @GetMapping("/accounts/{account_id}/messages")
    public List<Message> getMessagebyUserId(){
        return null;
    }

}
