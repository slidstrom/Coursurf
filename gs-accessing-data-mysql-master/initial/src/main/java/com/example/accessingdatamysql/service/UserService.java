/*
package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.model.User;
import com.example.accessingdatamysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // finds and returns all users in ArrayList<User>
    public ArrayList<User> findAll() {

        var it = userRepository.findAll();
        var users = new ArrayList<User>();

        for (User user : it) {
            users.add(user);
        }
        return users;
    }

    public Long count() {
        return userRepository.count();
    }

    // if id exists in the User table, return User object
    public User findUserById(Integer id) {

        User user;

        if (userRepository.existsById(id)) {

            user = new User();
            user.setId(id);
            return user;
        }
        return null;
    }

    public void deleteById(Integer userId) {
        userRepository.deleteById(userId);
    }
}
*/
