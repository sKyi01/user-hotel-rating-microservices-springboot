package com.springboot.user.services.service;

import com.springboot.user.services.entities.User;

import java.util.List;

public interface UserService {


    User saveUser(User u);

    User getUserById(String id);

    List<User> getAllUser();

    User updateUser(String id, User user);

    User deleteUser(String id);


}
