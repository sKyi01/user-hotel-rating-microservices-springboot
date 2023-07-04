package com.springboot.user.services.controller;


import com.springboot.user.services.entities.User;
import com.springboot.user.services.service.UserService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserServiceController {


    @Autowired
    private UserService userService;



    @PostMapping("/registerUser")
    public ResponseEntity<User> regiserUser(@RequestBody User u) {

        System.out.println("SKY");

        System.out.println("given output :" + u);

        User u1 = userService.saveUser(u);
        return ResponseEntity.status(HttpStatus.CREATED).body(u1);


    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {

        User u1 = userService.getUserById(id);
        return ResponseEntity.ok(u1);


    }

    @GetMapping("/getUserAll")
    public ResponseEntity<List<User>> getAll() {

        List<User> u1 = userService.getAllUser();
        return ResponseEntity.ok(u1);


    }


    @PutMapping("/updateUserById/{id}")
    public ResponseEntity<User> updateUserById(@RequestBody User u, @PathVariable String id){
        User u1=userService.updateUser(id,u);
        return ResponseEntity.status(HttpStatus.OK).body(u1);


    }

    @DeleteMapping("/deleteUserById/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable String id){

        User u1=userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(u1);
    }



}
