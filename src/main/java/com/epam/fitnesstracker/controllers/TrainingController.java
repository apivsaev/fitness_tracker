package com.epam.fitnesstracker.controllers;

import com.epam.fitnesstracker.controllers.exceptions.BadRequestException;
import com.epam.fitnesstracker.controllers.exceptions.NotFoundException;
import com.epam.fitnesstracker.controllers.utils.ValidationUtils;
import com.epam.fitnesstracker.domain.Training;
import com.epam.fitnesstracker.services.TrainingService;
import com.epam.fitnesstracker.services.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trainings")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @GetMapping("/withSets/{id}")
    public Training getTrainingWithSets(@PathVariable String id) throws BadRequestException, ServiceException, NotFoundException {
        Long trainingId = ValidationUtils.validateAdnGetLongParam(id, false, "Incorrect training id");

        Training training = trainingService.getTrainingWithSets(trainingId);

        if (training == null) {
            throw new NotFoundException("Training not found with id = " + id);
        }

        return training;
    }
}
