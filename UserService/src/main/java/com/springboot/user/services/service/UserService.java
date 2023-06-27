package com.springboot.user.services.service;


import com.springboot.user.services.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    User saveUser(User u);

    User getUserById(String id);

    List<User> getAllUser();

    User updateUser(String id, User user);

    User deleteUser(String id);


}
