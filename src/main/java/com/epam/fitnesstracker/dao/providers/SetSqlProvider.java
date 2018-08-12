package com.epam.fitnesstracker.dao.providers;

import com.epam.fitnesstracker.domain.Set;

public class SetSqlProvider {

    public String update(Set set) {
        StringBuilder query = new StringBuilder();
        query.append("update set set ");
        query.append("repeat = ").append(set.getRepeat()).append(", ");
        query.append("duration = ").append(set.getDuration()).append(", ");
        query.append("weight = ").append(set.getWeight());

        if (set.getExercise() != null && set.getExercise().getId() != null) {
            query.append(", exercise_id = ").append(set.getExercise().getId());
        }

        if (set.getTraining() != null && set.getTraining().getId() != null) {
            query.append(", training_id = ").append(set.getTraining().getId());
        }

        query.append(" where id = ").append(set.getId());

        return query.toString();
    }
}
