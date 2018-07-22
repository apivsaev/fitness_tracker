package com.epam.fitnesstracker.controllers;

import com.epam.fitnesstracker.controllers.exceptions.BadRequestException;
import com.epam.fitnesstracker.controllers.exceptions.NotFoundException;
import com.epam.fitnesstracker.controllers.utils.ValidationUtils;
import com.epam.fitnesstracker.domain.User;
import com.epam.fitnesstracker.services.UserService;
import com.epam.fitnesstracker.services.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

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

    @PostMapping()
    public ResponseEntity addUser(@RequestBody User user) throws BadRequestException, ServiceException {
        ValidationUtils.validateUser(user);
        Long userId = userService.addUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).body(user);
    }
}
