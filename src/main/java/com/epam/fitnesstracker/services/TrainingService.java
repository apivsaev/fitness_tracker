package com.epam.fitnesstracker.services;

import com.epam.fitnesstracker.domain.Training;
import com.epam.fitnesstracker.services.exceptions.ServiceException;

import java.util.List;

public interface TrainingService {

    Training getTrainingWithSets(Long id) throws ServiceException;

    List<Training> getUserTrainings(Long userId) throws ServiceException;

    Training getById(Long id) throws ServiceException;

    Long add(Training training) throws ServiceException;

    Integer update(Training training) throws ServiceException;

    Integer delete(Long id) throws ServiceException;
}
