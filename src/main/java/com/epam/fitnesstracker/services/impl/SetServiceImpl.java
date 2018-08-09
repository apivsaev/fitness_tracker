package com.epam.fitnesstracker.services.impl;

import com.epam.fitnesstracker.dao.SetDao;
import com.epam.fitnesstracker.domain.Set;
import com.epam.fitnesstracker.services.SetService;
import com.epam.fitnesstracker.services.exceptions.ServiceException;
import com.epam.fitnesstracker.services.utils.ServiceExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SetServiceImpl implements SetService {

    @Autowired
    private SetDao setDao;

    @Override
    public Set getById(Long id) throws ServiceException {
        try {
            return setDao.getById(id);
        } catch (Exception e) {
            throw ServiceExceptionUtils.handleException(e);
        }
    }

    @Override
    public Long add(Set set) throws ServiceException {
        try {
            setDao.add(set);
            return set.getId();
        } catch (Exception e) {
            throw ServiceExceptionUtils.handleException(e);
        }
    }

    @Override
    public Integer update(Set set) throws ServiceException {
        try {
            return setDao.update(set);
        } catch (Exception e) {
            throw ServiceExceptionUtils.handleException(e);
        }
    }

    @Override
    public Integer delete(Long id) throws ServiceException {
        try {
            return setDao.delete(id);
        } catch (Exception e) {
            throw ServiceExceptionUtils.handleException(e);
        }
    }
}
