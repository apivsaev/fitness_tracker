package com.epam.fitnesstracker.services;

import com.epam.fitnesstracker.domain.User;
import com.epam.fitnesstracker.services.exceptions.ServiceException;

public interface UserService {

    User getById(Integer id) throws ServiceException;
}
