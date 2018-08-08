package com.epam.fitnesstracker.controllers;

import com.epam.fitnesstracker.controllers.exceptions.BadRequestException;
import com.epam.fitnesstracker.controllers.exceptions.NotFoundException;
import com.epam.fitnesstracker.controllers.utils.ValidationUtils;
import com.epam.fitnesstracker.domain.User;
import com.epam.fitnesstracker.services.UserService;
import com.epam.fitnesstracker.services.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public List<User> get() throws NotFoundException, ServiceException {
        List<User> users = userService.get();

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
    public ResponseEntity add(@RequestBody User user) throws BadRequestException, ServiceException {
        ValidationUtils.validateUser(user);

        Long userId = userService.add(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userId).toUri();
        return ResponseEntity.created(location).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) throws BadRequestException, ServiceException {
        Long userId = ValidationUtils.validateAdnGetLongParam(id, false, "Incorrect user id " + id);

        Integer deleteCount = userService.delete(userId);

        HttpStatus status = deleteCount > 0 ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/users").build().toUri();
        return ResponseEntity.status(status).location(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody User user) throws BadRequestException, ServiceException {
        Long userId = ValidationUtils.validateAdnGetLongParam(id, false, "Incorrect user id " + id);
        ValidationUtils.validateUser(user);

        user.setId(userId);
        Integer updateCount = userService.update(user);

        HttpStatus status = updateCount > 0 ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        URI location = updateCount > 0 ? ServletUriComponentsBuilder.fromCurrentRequest().build().toUri() : null;
        return ResponseEntity.status(status).location(location).build();
    }
}
