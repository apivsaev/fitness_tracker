package com.epam.fitnesstracker.services.impl;

import com.epam.fitnesstracker.dao.UserDao;
import com.epam.fitnesstracker.domain.User;
import com.epam.fitnesstracker.services.UserService;
import com.epam.fitnesstracker.services.exceptions.ServiceException;
import com.epam.fitnesstracker.services.utils.ServiceExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers() throws ServiceException {
        try {
            return userDao.getUsers();
        } catch (Exception e) {
            throw ServiceExceptionUtils.handleException(e);
        }
    }

    @Override
    public User getById(Long id) throws ServiceException {
        try {
            return userDao.getById(id);
        } catch (Exception e) {
            throw ServiceExceptionUtils.handleException(e);
        }
    }

    @Override
    public Long addUser(User user) throws ServiceException {
        try {
            userDao.addUser(user);
            return userDao.getLastInsertedId();
        } catch (Exception e) {
            throw ServiceExceptionUtils.handleException(e);
        }
    }
}
