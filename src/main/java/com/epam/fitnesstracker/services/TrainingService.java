package com.epam.fitnesstracker.services;

import com.epam.fitnesstracker.domain.Training;
import com.epam.fitnesstracker.services.exceptions.ServiceException;

public interface TrainingService {

    Training getTrainingWithSets(Long id) throws ServiceException;
}
