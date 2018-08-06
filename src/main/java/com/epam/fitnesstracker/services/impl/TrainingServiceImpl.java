package com.epam.fitnesstracker.services.impl;

import com.epam.fitnesstracker.dao.TrainingDao;
import com.epam.fitnesstracker.domain.Training;
import com.epam.fitnesstracker.services.TrainingService;
import com.epam.fitnesstracker.services.exceptions.ServiceException;
import com.epam.fitnesstracker.services.utils.ServiceExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
