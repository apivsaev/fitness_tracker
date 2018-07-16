package com.epam.fitnesstracker.services.impl;

import com.epam.fitnesstracker.dao.UserDao;
import com.epam.fitnesstracker.domain.User;
import com.epam.fitnesstracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getById(Integer id) {
        return userDao.getById(id);
        //return new User(id, "Alex", 25);
    }
}
