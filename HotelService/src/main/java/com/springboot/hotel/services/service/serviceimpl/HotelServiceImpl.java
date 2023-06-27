package com.springboot.hotel.services.service.serviceimpl;

import com.springboot.hotel.services.entities.Hotel;
import com.springboot.hotel.services.exception.ResourceNotFoundException;
import com.springboot.hotel.services.repository.HotelRepository;
import com.springboot.hotel.services.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        String token = UUID.randomUUID().toString();
        hotel.setHotelId(token);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found By Provided Id"));
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel updateHotel(String id, Hotel hotel) {
        Optional<Hotel> h1 = hotelRepository.findById(id);
        Hotel h2 = h1.get();
        h2.setHotelId(hotel.getHotelId());
        h2.setName(hotel.getName());
        h2.setAbout(hotel.getAbout());
        h2.setLocation(hotel.getLocation());
        return h2;
    }

    @Override
    public Hotel deleteHotelById(String id) {
        {
            Optional<Hotel> hotel = hotelRepository.findById(id);
            Hotel h1 = hotel.get();
            hotelRepository.delete(h1);


            return h1;
        }
    }
}
