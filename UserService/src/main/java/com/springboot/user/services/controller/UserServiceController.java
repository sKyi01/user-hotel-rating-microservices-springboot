package com.springboot.user.services.controller;


import com.springboot.user.services.entities.User;
import com.springboot.user.services.service.UserService;
import com.springboot.user.services.service.UserServiceImpl;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserServiceController {


    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserService userService;


    //User Registration Url
    @PostMapping("/registerUser")
    public ResponseEntity<User> regiserUser(@RequestBody User u) {

        System.out.println("SKY");

        System.out.println("given output :" + u);

        User u1 = userService.saveUser(u);
        return ResponseEntity.status(HttpStatus.CREATED).body(u1);


    }

    //Get User By Id Url

    int retryCount = 0;

    @GetMapping("/getUserById/{id}")
    //@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    //@Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "ratingHotelLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUserById(@PathVariable String id) {

        logger.info("get single use handler ; UserController");
        logger.info("Retry Count : " + retryCount);
        retryCount++;

        User u1 = userService.getUserById(id);
        return ResponseEntity.ok(u1);


    }

    // Implementing Fallback method
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {
        logger.info("Fallback is executed because service is down ;" + ex.getMessage());
        User user = User.builder().email("dummy@gmail.com").name("dunno").about("service is down").userId("5435").build();


        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/getUserAll")
    public ResponseEntity<List<User>> getAll() {

        List<User> u1 = userService.getAllUser();
        return ResponseEntity.ok(u1);


    }


    @PutMapping("/updateUserById/{id}")
    public ResponseEntity<User> updateUserById(@RequestBody User u, @PathVariable String id) {
        User u1 = userService.updateUser(id, u);
        return ResponseEntity.status(HttpStatus.OK).body(u1);


    }

    @DeleteMapping("/deleteUserById/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable String id) {

        User u1 = userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(u1);
    }


}
