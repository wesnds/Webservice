package com.webservices.webservice.controllers;

import com.webservices.webservice.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User user = new User(1L, "Wes", "wesnds@gmail.com", "000000000", "12345");
        return ResponseEntity.ok().body(user);
    }

}
