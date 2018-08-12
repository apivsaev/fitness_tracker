package com.epam.fitnesstracker.dao.providers;

import com.epam.fitnesstracker.domain.Exercise;
import com.epam.fitnesstracker.domain.Set;
import com.epam.fitnesstracker.domain.Training;
import org.junit.Assert;
import org.junit.Test;

public class SetSqlProviderTest {

    private static final String UPDATE_ALL_FIELDS_SQL = "update set set repeat = 5, duration = 1000, weight = 20.0, exercise_id = 1, training_id = 2 where id = 1";
    private static final String UPDATE_WITH_NULL_REPEAT_SQL = "update set set repeat = null, duration = 1000, weight = 20.0, exercise_id = 1, training_id = 2 where id = 1";
    private static final String UPDATE_WITH_NULL_TRAINING_SQL = "update set set repeat = 5, duration = 1000, weight = 20.0, exercise_id = 1 where id = 1";
    private static final String UPDATE_WITH_NULL_EXERCISE_SQL = "update set set repeat = 5, duration = 1000, weight = 20.0, training_id = 2 where id = 1";

    private SetSqlProvider setSqlProvider = new SetSqlProvider();

    @Test
    public void testUpdateAllFields() {
        Set set = buildSet();

        String sql = setSqlProvider.update(set);
        Assert.assertEquals(UPDATE_ALL_FIELDS_SQL, sql);
    }

    @Test
    public void testUpdateWithNullRepeat() {
        Set set = buildSet();
        set.setRepeat(null);

        String sql = setSqlProvider.update(set);
        Assert.assertEquals(UPDATE_WITH_NULL_REPEAT_SQL, sql);
    }

    @Test
    public void testUpdateWithNullTraining() {
        Set set = buildSet();
        set.setTraining(null);

        String sql = setSqlProvider.update(set);
        Assert.assertEquals(UPDATE_WITH_NULL_TRAINING_SQL, sql);
    }

    @Test
    public void testUpdateWithNullExercise() {
        Set set = buildSet();
        set.setExercise(null);

        String sql = setSqlProvider.update(set);
        Assert.assertEquals(UPDATE_WITH_NULL_EXERCISE_SQL, sql);
    }

    private Set buildSet() {
        Exercise exercise = new Exercise();
        exercise.setId(1L);

        Training training = new Training();
        training.setId(2L);

        Set set = new Set();
        set.setId(1L);
        set.setDuration(1000);
        set.setRepeat(5);
        set.setWeight(20.0);
        set.setTraining(training);
        set.setExercise(exercise);
        return set;
    }
}
