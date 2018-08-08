package com.epam.fitnesstracker.services;

import com.epam.fitnesstracker.domain.Exercise;
import com.epam.fitnesstracker.services.exceptions.ServiceException;

import java.util.List;

public interface ExerciseService {

    List<Exercise> get() throws ServiceException;

    Exercise getById(Long id) throws ServiceException;

    Long add(Exercise exercise) throws ServiceException;

    Integer update(Exercise exercise) throws ServiceException;

    Integer delete(Long id) throws ServiceException;
}
