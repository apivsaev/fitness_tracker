package com.epam.fitnesstracker.services.impl;

import com.epam.fitnesstracker.dao.ExerciseDao;
import com.epam.fitnesstracker.domain.Exercise;
import com.epam.fitnesstracker.services.ExerciseService;
import com.epam.fitnesstracker.services.exceptions.ServiceException;
import com.epam.fitnesstracker.services.utils.ServiceExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private ExerciseDao exerciseDao;

    @Override
    public List<Exercise> get() throws ServiceException {
        try {
            return exerciseDao.get();
        } catch (Exception e) {
            throw ServiceExceptionUtils.handleException(e);
        }
    }

    @Override
    public Exercise getById(Long id) throws ServiceException {
        try {
            return exerciseDao.getById(id);
        } catch (Exception e) {
            throw ServiceExceptionUtils.handleException(e);
        }
    }

    @Override
    public Long add(Exercise exercise) throws ServiceException {
        try {
            exerciseDao.add(exercise);
            return exercise.getId();
        } catch (Exception e) {
            throw ServiceExceptionUtils.handleException(e);
        }
    }

    @Override
    public Integer update(Exercise exercise) throws ServiceException {
        try {
            return exerciseDao.update(exercise);
        } catch (Exception e) {
            throw ServiceExceptionUtils.handleException(e);
        }
    }

    @Override
    public Integer delete(Long id) throws ServiceException {
        try {
            return exerciseDao.delete(id);
        } catch (DataIntegrityViolationException e) {
            throw ServiceExceptionUtils.handleException(new ServiceException("Can't delete exercise. It uses in set", e));
        } catch (Exception e) {
            throw ServiceExceptionUtils.handleException(e);
        }
    }
}
