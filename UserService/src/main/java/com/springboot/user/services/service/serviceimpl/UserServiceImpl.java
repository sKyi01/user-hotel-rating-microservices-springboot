package com.springboot.user.services.service.serviceimpl;

import com.springboot.user.services.entities.User;
import com.springboot.user.services.exception.ResourceNotFoundException;
import com.springboot.user.services.exception.UserNotFoundException;
import com.springboot.user.services.repository.UserRepository;
import com.springboot.user.services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User saveUser(User u) {
        String userId = UUID.randomUUID().toString();
        u.setUserId(userId);
        return userRepo.save(u);
    }


    @Override
    public User getUserById(String id) {

        return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found By Provided Id"));

    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
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
