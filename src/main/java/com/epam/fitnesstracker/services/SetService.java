package com.epam.fitnesstracker.services;

import com.epam.fitnesstracker.domain.Set;
import com.epam.fitnesstracker.services.exceptions.ServiceException;

public interface SetService {

    Set getById(Long id) throws ServiceException;

    Long add(Set set) throws ServiceException;

    Integer update(Set set) throws ServiceException;

    Integer delete(Long id) throws ServiceException;
}
