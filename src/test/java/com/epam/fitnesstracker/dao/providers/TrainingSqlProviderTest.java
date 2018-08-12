package com.epam.fitnesstracker.dao.providers;

import com.epam.fitnesstracker.domain.Training;
import com.epam.fitnesstracker.domain.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class TrainingSqlProviderTest {

    private static final String UPDATE_ALL_FIELDS_SQL = "update training set date = '2000-12-31 15:15:30.200', calories = 1000, user_id = 2 where id = 1";
    private static final String UPDATE_WITH_NULL_DATE_SQL = "update training set date = null, calories = 1000, user_id = 2 where id = 1";
    private static final String UPDATE_WITH_NULL_USER_SQL = "update training set date = '2000-12-31 15:15:30.200', calories = 1000 where id = 1";

    private TrainingSqlProvider trainingSqlProvider = new TrainingSqlProvider();

    @Test
    public void testUpdateAllFields() {
        Training training = buildTraining();
        String sql = trainingSqlProvider.update(training);

        Assert.assertEquals(UPDATE_ALL_FIELDS_SQL, sql);
    }

    @Test
    public void testUpdateWithNullDate() {
        Training training = buildTraining();
        training.setDate(null);
        String sql = trainingSqlProvider.update(training);

        Assert.assertEquals(UPDATE_WITH_NULL_DATE_SQL, sql);
    }

    @Test
    public void testUpdateWithNullUser() {
        Training training = buildTraining();
        training.setUser(null);
        String sql = trainingSqlProvider.update(training);

        Assert.assertEquals(UPDATE_WITH_NULL_USER_SQL, sql);
    }

    private Training buildTraining() {
        User user = new User();
        user.setId(2L);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.DECEMBER, 31, 15, 15, 30);
        calendar.set(Calendar.MILLISECOND, 200);

        Training training = new Training();
        training.setId(1L);
        training.setDate(calendar.getTime());
        training.setCalories(1000);
        training.setUser(user);

        return training;
    }


}
