package com.epam.fitnesstracker.controllers;

import com.epam.fitnesstracker.services.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    private int count;

    @RequestMapping("/hello")
    public String hello() {
        count++;
        return "Hello " + count;
    }
}
