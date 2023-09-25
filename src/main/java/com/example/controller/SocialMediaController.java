package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.AccountService;
import com.example.service.MessageService;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */

    // POST: register
    // POST: login
    // POST: messages
    // GET: messages
    // GET: messagesById
    // DELETE: messagesById
    // PATCH: messagesById
    // GET: messagesByUserId
 
//added @RestController
@RestController
public class SocialMediaController {
    public AccountService accountService;
    public MessageService messageService;

    @Autowired
    public SocialMediaController(AccountService accountService, MessageService messageService){
        this.accountService = accountService;
        this.messageService = messageService;
    }

    //POST  /register

    //POST  /login

    //POST  /messages

    //GET   /messages

    //GET by id     /messages/{message_id}

    //DELETE by id  /messages/{message_id}

    //UPDATE by id  /messages/{message_id}

    //GET by account id /accounts/{account_id}/messages

}
