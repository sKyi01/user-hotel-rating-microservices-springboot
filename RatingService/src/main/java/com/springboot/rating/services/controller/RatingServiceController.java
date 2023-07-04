package com.springboot.rating.services.controller;

import com.springboot.rating.services.entities.Rating;
import com.springboot.rating.services.service.RatingService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingServiceController {

    @Autowired
    private RatingService ratingService;


    @PostMapping("/saveRating")
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {

        Rating r1 = ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(r1);


    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<List<Rating>> getByUserId(@PathVariable String id) {

        List<Rating> r1 = ratingService.getRatingByUserId(id);
        return ResponseEntity.status(HttpStatus.OK).body(r1);


    }

    @GetMapping("/getHotelById/{id}")
    public ResponseEntity<List<Rating>> getByHotelId(@PathVariable String id) {

        List<Rating> r1 = ratingService.getRatingByHotelId(id);
        return ResponseEntity.status(HttpStatus.OK).body(r1);


    }

    @GetMapping("/getAllRating")
    public ResponseEntity<List<Rating>> getAllRating() {

        List<Rating> r1 = ratingService.getAllRating();
        return ResponseEntity.status(HttpStatus.OK).body(r1);


    }




}
