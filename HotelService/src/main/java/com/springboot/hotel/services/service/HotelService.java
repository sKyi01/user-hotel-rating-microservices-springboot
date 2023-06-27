package com.springboot.hotel.services.service;


import com.springboot.hotel.services.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {

    Hotel saveHotel(Hotel hotel);

    Hotel getHotelById(String id);

    List<Hotel> getAll();

    Hotel updateHotel(String id, Hotel hotel);

    Hotel deleteHotelById(String id);


}
