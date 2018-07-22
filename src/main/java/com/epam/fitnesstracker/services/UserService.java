package com.epam.fitnesstracker.services;

import com.epam.fitnesstracker.domain.User;
import com.epam.fitnesstracker.services.exceptions.ServiceException;

import java.util.List;

public interface UserService {

    List<User> getUsers() throws ServiceException;

    User getById(Long id) throws ServiceException;

    Long addUser(User user) throws ServiceException;
}
