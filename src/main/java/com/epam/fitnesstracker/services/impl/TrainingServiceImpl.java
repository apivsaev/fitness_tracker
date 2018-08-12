package com.epam.fitnesstracker.services.impl;

import com.epam.fitnesstracker.dao.TrainingDao;
import com.epam.fitnesstracker.domain.Training;
import com.epam.fitnesstracker.services.TrainingService;
import com.epam.fitnesstracker.services.exceptions.ServiceException;
import com.epam.fitnesstracker.services.utils.ServiceExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingDao trainingDao;

    @Override
    public Training getTrainingWithSets(Long id) throws ServiceException {
        try {
            return trainingDao.getTrainingWithSets(id);
        } catch (Exception e) {
            throw ServiceExceptionUtils.handleException(e);
        }
    }

    @Override
    public List<Training> getUserTrainings(Long userId) throws ServiceException {
        try {
            return trainingDao.getUserTrainings(userId);
        } catch (Exception e) {
            throw ServiceExceptionUtils.handleException(e);
        }
    }

    @Override
    public Training getById(Long id) throws ServiceException {
        try {
            return trainingDao.getById(id);
        } catch (Exception e) {
            throw ServiceExceptionUtils.handleException(e);
        }
    }

    @Override
    public Long add(Training training) throws ServiceException {
        try {
            trainingDao.add(training);
            return training.getId();
        } catch (Exception e) {
            throw ServiceExceptionUtils.handleException(e);
        }
    }

    @Override
    public Integer update(Training training) throws ServiceException {
        try {
            return trainingDao.update(training);
        } catch (Exception e) {
            throw ServiceExceptionUtils.handleException(e);
        }
    }

    @Override
    public Integer delete(Long id) throws ServiceException {
        try {
            return trainingDao.delete(id);
        } catch (Exception e) {
            throw ServiceExceptionUtils.handleException(e);
        }
    }
}
