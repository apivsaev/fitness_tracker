package com.epam.fitnesstracker.dao.providers;

import com.epam.fitnesstracker.domain.Training;

import java.text.SimpleDateFormat;

public class TrainingSqlProvider {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

    public String update(Training training) {
        StringBuilder sql = new StringBuilder();
        sql.append("update training set ");

        if (training.getDate() == null) {
            sql.append("date = null, ");
        } else {
            String date = dateFormat.format(training.getDate());
            sql.append("date = '").append(date).append("', ");
        }

        sql.append("calories = ").append(training.getCalories());

        if (training.getUser() != null && training.getUser().getId() != null) {
            sql.append(", user_id = ").append(training.getUser().getId());
        }

        sql.append(" where id = ").append(training.getId());

        return sql.toString();
    }
}
