package com.epam.fitnesstracker.controllers;

import com.epam.fitnesstracker.controllers.exceptions.BadRequestException;
import com.epam.fitnesstracker.controllers.exceptions.NotFoundException;
import com.epam.fitnesstracker.controllers.utils.ValidationUtils;
import com.epam.fitnesstracker.domain.Exercise;
import com.epam.fitnesstracker.services.ExerciseService;
import com.epam.fitnesstracker.services.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping
    public List<Exercise> get() throws ServiceException, NotFoundException {
        List<Exercise> exercises = exerciseService.get();

        if (exercises == null || exercises.isEmpty()) {
            throw new NotFoundException("Exercises not found");
        }

        return exercises;
    }

    @GetMapping("/{id}")
    public Exercise getById(@PathVariable String id) throws BadRequestException, ServiceException, NotFoundException {
        Long exerciseId = ValidationUtils.validateAdnGetLongParam(id, false, "Incorrect exercise id " + id);

        Exercise exercise = exerciseService.getById(exerciseId);

        if (exercise == null) {
            throw new NotFoundException("Exercise not found with id = " + id);
        }

        return exercise;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Exercise exercise) throws BadRequestException, ServiceException {
        ValidationUtils.validateExercise(exercise);

        Long exerciseId = exerciseService.add(exercise);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(exerciseId).toUri();
        return ResponseEntity.created(location).body(exercise);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody Exercise exercise) throws BadRequestException, ServiceException {
        Long exerciseId = ValidationUtils.validateAdnGetLongParam(id, false, "Incorrect exercise id " + id);
        ValidationUtils.validateExercise(exercise);

        exercise.setId(exerciseId);
        Integer updatedCount = exerciseService.update(exercise);

        HttpStatus status = updatedCount > 0 ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        URI location = updatedCount > 0 ? ServletUriComponentsBuilder.fromCurrentRequest().build().toUri() : null;
        return ResponseEntity.status(status).location(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) throws BadRequestException, ServiceException {
        Long exerciseId = ValidationUtils.validateAdnGetLongParam(id, false, "Incorrect exercise id " + id);

        Integer deleteCount = exerciseService.delete(exerciseId);

        HttpStatus status = deleteCount > 0 ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        URI location = deleteCount > 0 ? ServletUriComponentsBuilder.fromCurrentContextPath().path("/exercises").build().toUri() : null;
        return ResponseEntity.status(status).location(location).build();
    }

}
