package com.epam.fitnesstracker.controllers;

import com.epam.fitnesstracker.domain.User;
import com.epam.fitnesstracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/{id}")
    public String getById(@PathVariable String id) {
        try {
            User user = userService.getById(Integer.parseInt(id));
            if (user != null) {
                return String.format("id: %d, name: %s, age: %d", user.getId(), user.getName(), user.getAge());
            } else {
                return "Not found";
            }
        } catch (NumberFormatException e) {
            //TODO Log e
            return "Incorrect id";
        }
    }
}
