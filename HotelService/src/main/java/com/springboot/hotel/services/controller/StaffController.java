package com.springboot.hotel.services.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {


    @GetMapping("/getStaff")
    public ResponseEntity<List<String>> getStaff(){

        List<String> list= Arrays.asList("Akash","SKY","Kakasaheb","Patil");
        return ResponseEntity.status(HttpStatus.OK).body(list);


    }

}
