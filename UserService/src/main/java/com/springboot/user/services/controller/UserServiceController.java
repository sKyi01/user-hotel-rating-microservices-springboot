package com.springboot.user.services.controller;


import com.springboot.user.services.entities.User;

import com.springboot.user.services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserServiceController {



    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> regiserUser(@RequestBody User u) {

        System.out.println("given output :"+ u);

        User u1 = userService.saveUser(u);
        return ResponseEntity.status(HttpStatus.CREATED).body(u1);


    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {

        User u1 = userService.getUserById(id);
        return ResponseEntity.ok(u1);


    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAll() {

        List<User> u1 = userService.getAllUser();
        return ResponseEntity.ok(u1);


    }

}
