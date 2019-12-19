/*
package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.model.User;
import com.example.accessingdatamysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ArrayList<User> allUsers() {
        // returns json formatted list of all users in User table
        return userService.findAll();
    }

    @GetMapping("/users/count")
    public Long count() {
        // returns count of all users in User table
        return userService.count();
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable String id) {

        Integer userId = Integer.getInteger(id);
        userService.deleteById(userId);
    }
}

*/
