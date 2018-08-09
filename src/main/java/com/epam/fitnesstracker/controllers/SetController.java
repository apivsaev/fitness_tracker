package com.epam.fitnesstracker.controllers;

import com.epam.fitnesstracker.controllers.exceptions.BadRequestException;
import com.epam.fitnesstracker.controllers.exceptions.NotFoundException;
import com.epam.fitnesstracker.controllers.utils.ValidationUtils;
import com.epam.fitnesstracker.domain.Set;
import com.epam.fitnesstracker.services.SetService;
import com.epam.fitnesstracker.services.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/sets")
public class SetController {

    @Autowired
    private SetService setService;

    @GetMapping("/{id}")
    public Set getById(@PathVariable String id) throws BadRequestException, ServiceException, NotFoundException {
        Long setId = ValidationUtils.validateAdnGetLongParam(id, false, "Incorrect set id " + id);

        Set set = setService.getById(setId);

        if (set == null) {
            throw new NotFoundException("Set not found with id = " + id);
        }

        return set;
    }

    @PostMapping()
    public ResponseEntity add(@RequestBody Set set) throws BadRequestException, ServiceException {
        ValidationUtils.validateSet(set);

        Long setId = setService.add(set);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(setId).toUri();
        return ResponseEntity.created(location).body(set);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody Set set) throws BadRequestException, ServiceException {
        Long setId = ValidationUtils.validateAdnGetLongParam(id, false, "Incorrect set id " + id);
        ValidationUtils.validateSet(set);

        set.setId(setId);
        Integer updatedCount = setService.update(set);

        HttpStatus status = updatedCount > 0 ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        URI location = updatedCount > 0 ? ServletUriComponentsBuilder.fromCurrentRequest().build().toUri() : null;
        return ResponseEntity.status(status).location(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) throws BadRequestException, ServiceException {
        Long setId = ValidationUtils.validateAdnGetLongParam(id, false, "Incorrect set id " + id);

        Integer deleteCount = setService.delete(setId);

        HttpStatus status = deleteCount > 0 ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        URI location = deleteCount > 0 ? ServletUriComponentsBuilder.fromCurrentContextPath().path("/sets").build().toUri() : null;
        return ResponseEntity.status(status).location(location).build();
    }
}
