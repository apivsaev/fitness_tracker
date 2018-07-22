package com.epam.fitnesstracker.controllers;

import com.epam.fitnesstracker.controllers.exceptions.BadRequestException;
import com.epam.fitnesstracker.controllers.exceptions.NotFoundException;
import com.epam.fitnesstracker.domain.User;
import com.epam.fitnesstracker.services.UserService;
import com.epam.fitnesstracker.services.exceptions.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/user/{id}")
    public User getById(@PathVariable String id) throws NotFoundException, BadRequestException, ServiceException {
        try {
            User user = userService.getById(Integer.parseInt(id));
            if (user != null) {
                return user;
            } else {
                throw new NotFoundException("User not found with id = " + id);
            }
        } catch (NumberFormatException e) {
            LOGGER.debug("Incorrect id", e);
            throw new BadRequestException("Incorrect user id " + id, e);
        }
    }
}
