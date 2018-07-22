package com.epam.fitnesstracker.controllers;

import com.epam.fitnesstracker.controllers.exceptions.BadRequestException;
import com.epam.fitnesstracker.controllers.exceptions.NotFoundException;
import com.epam.fitnesstracker.controllers.utils.ValidationUtils;
import com.epam.fitnesstracker.domain.User;
import com.epam.fitnesstracker.services.UserService;
import com.epam.fitnesstracker.services.exceptions.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() throws NotFoundException, ServiceException {
        List<User> users = userService.getUsers();

        if (users == null || users.isEmpty()) {
            throw new NotFoundException("Users not found");
        }

        return users;
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable String id) throws NotFoundException, BadRequestException, ServiceException {
        Long userId = ValidationUtils.validateAdnGetLongParam(id, false, "Incorrect user id " + id);
        User user = userService.getById(userId);
        if (user == null) {
            throw new NotFoundException("User not found with id = " + id);
        }

        return user;
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody User user) throws ServiceException {
        Long userId = userService.addUser(user);
        return ResponseEntity.ok(userId);
    }
}
