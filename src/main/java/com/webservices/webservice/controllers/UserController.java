package com.webservices.webservice.controllers;

import com.webservices.webservice.entities.User;
import com.webservices.webservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> usersList = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(usersList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id){
        User user = userService.findUserById(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(user);
    }

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User newUser){
        newUser = userService.registerUser(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User uptUser){
        uptUser = userService.updateUser(id, uptUser);
        return ResponseEntity.status(HttpStatus.OK).body(uptUser);
    }

}
