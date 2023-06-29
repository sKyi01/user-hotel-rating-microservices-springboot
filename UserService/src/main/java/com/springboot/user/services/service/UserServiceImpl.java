package com.springboot.user.services.service;

import com.springboot.user.services.entities.Hotel;
import com.springboot.user.services.entities.Rating;
import com.springboot.user.services.entities.User;
import com.springboot.user.services.exception.ResourceNotFoundException;
import com.springboot.user.services.exception.UserNotFoundException;
import com.springboot.user.services.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User u) {
        String userId = UUID.randomUUID().toString();
        u.setUserId(userId);
        return userRepo.save(u);
    }


    @Override
    public User getUserById(String id) {

        User user=userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found By Provided Id !!!"));
        Rating[] ratingOfUser=restTemplate.getForObject("http://localhost:6543/rating/getUserById/"+user.getUserId(), Rating[].class);
        logger.info("{}",ratingOfUser);

        List<Rating> ratings=Arrays.stream(ratingOfUser).toList();
        List<Rating> ratingList= ratings.stream().map(rating -> {

                    ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:5432/hotel/getHotelById/" + rating.getHotelId(), Hotel.class);
                    Hotel hotel = forEntity.getBody();
                    logger.info("response status code : {} ", forEntity.getStatusCode());

                    rating.setHotel(hotel);
                    return rating;
                }

        ).collect(Collectors.toList());


        user.setRating(ratingList);
        return user;
    }

    @Override
    public List<User> getAllUser() {

        //User u=new User();


        List<User> user=userRepo.findAll();





        return user;
    }


    @Override
    public User updateUser(String id, User user) {
        Optional<User> u1 = userRepo.findById(id);
        if (u1.isPresent()) {
            User u2 = u1.get();
            u2.setName(user.getName());
            u2.setEmail(user.getEmail());
            u2.setAbout(user.getAbout());
            userRepo.save(u2);
            return u2;


        } else {

            throw new UserNotFoundException();
        }
    }


    @Override
    public User deleteUser(String id) {
        Optional<User> user = userRepo.findById(id);
        User u1 = user.get();
        userRepo.delete(u1);
        return u1;

    }
}
