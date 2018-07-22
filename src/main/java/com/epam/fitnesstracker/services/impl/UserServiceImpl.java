package com.epam.fitnesstracker.services.impl;

import com.epam.fitnesstracker.dao.UserDao;
import com.epam.fitnesstracker.domain.User;
import com.epam.fitnesstracker.services.UserService;
import com.epam.fitnesstracker.services.exceptions.ServiceException;
import com.epam.fitnesstracker.services.utils.ServiceExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public User getById(Integer id) throws ServiceException {
        try {
            return userDao.getById(id);
        } catch (Exception e) {
            throw ServiceExceptionUtils.handleException(e);
        }
    }
}
