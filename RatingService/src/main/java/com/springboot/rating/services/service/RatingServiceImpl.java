package com.springboot.rating.services.service;

import com.springboot.rating.services.entities.Rating;
import com.springboot.rating.services.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating saveRating(Rating rating) {
        String token= UUID.randomUUID().toString();
        rating.setRatingId(token);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.getRatingByUserId(userId);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.getRatingByHotelId(hotelId);
    }
}
