package com.springboot.hotel.services.controller;

import com.springboot.hotel.services.entities.Hotel;
import com.springboot.hotel.services.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelServiceController {
    @Autowired
    private HotelService hotelService;

    @PostMapping("/saveHotel")
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {

        Hotel h1 = hotelService.saveHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(h1);


    }

    @GetMapping("/getHotelById/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String id) {

        Hotel h1 = hotelService.getHotelById(id);
        return ResponseEntity.status(HttpStatus.OK).body(h1);


    }

    @GetMapping("/getHotelAll")
    public ResponseEntity<List<Hotel>> getHotelAll() {

        List<Hotel> h1 = hotelService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(h1);


    }

    @PutMapping("/updateHotelById/{id}")
    public ResponseEntity<Hotel> updateHotelById(@PathVariable String id,@RequestBody Hotel hotel) {



        Hotel h1 = hotelService.updateHotel(id,hotel);
        return ResponseEntity.status(HttpStatus.OK).body(h1);


    }

    @DeleteMapping("/deleteHotelById/{id}")
    public ResponseEntity<Hotel> deleteHotelById(@PathVariable String id){
        Hotel h1=hotelService.deleteHotelById(id);
        return ResponseEntity.status(HttpStatus.OK).body(h1);


    }




}
