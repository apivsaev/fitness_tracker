package com.epam.fitnesstracker.services;

import com.epam.fitnesstracker.domain.User;
import com.epam.fitnesstracker.services.exceptions.ServiceException;

import java.util.List;

public interface UserService {

    List<User> get() throws ServiceException;

    User getById(Long id) throws ServiceException;

    Long add(User user) throws ServiceException;

    Integer delete(Long id) throws ServiceException;

    Integer update(User user) throws ServiceException;
}
