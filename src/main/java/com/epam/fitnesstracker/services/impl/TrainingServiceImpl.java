package com.epam.fitnesstracker.services.impl;

import com.epam.fitnesstracker.services.TrainingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TrainingServiceImpl implements TrainingService {

    @Override
    public boolean addTraining() {
        return true;
    }
}
