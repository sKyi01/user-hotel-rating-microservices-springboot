package com.springboot.rating.services.service;

import com.springboot.rating.services.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

    Rating saveRating(Rating rating);

    List<Rating> getRatingByUserId(String id);

    List<Rating> getAllRating();

    List<Rating> getRatingByHotelId(String hotelId);


}
