package com.epam.fitnesstracker.domain;

import java.util.Date;
import java.util.List;

public class Training {

    private Long id;

    private Date date;

    private Integer calories;

    private User user;

    private List<Set> sets;

    public Training() {

    }

    public Training(Long id, Date date, Integer calories, User user, List<Set> sets) {
        this.id = id;
        this.date = date;
        this.calories = calories;
        this.user = user;
        this.sets = sets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Set> getSets() {
        return sets;
    }

    public void setSets(List<Set> sets) {
        this.sets = sets;
    }
}
