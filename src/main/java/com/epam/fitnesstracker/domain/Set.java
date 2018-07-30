package com.epam.fitnesstracker.domain;

public class Set {

    private Long id;

    private Integer repeat;

    private Integer duration;

    private Double weight;

    private Exercise exercise;

    private Training training;

    public Set() {

    }

    public Set(Long id, Integer repeat, Integer duration, Double weight, Exercise exercise, Training training) {
        this.id = id;
        this.repeat = repeat;
        this.duration = duration;
        this.weight = weight;
        this.exercise = exercise;
        this.training = training;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRepeat() {
        return repeat;
    }

    public void setRepeat(Integer repeat) {
        this.repeat = repeat;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }
}
