package com.epam.fitnesstracker.dao;

import com.epam.fitnesstracker.dao.providers.SetSqlProvider;
import com.epam.fitnesstracker.domain.Exercise;
import com.epam.fitnesstracker.domain.Set;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface SetDao {

    @Select("select * from set where id = #{id}")
    @Results({
            @Result(property = "exercise", column = "exercise_id", javaType = Exercise.class, one = @One(select = "com.epam.fitnesstracker.dao.ExerciseDao.getById", fetchType = FetchType.EAGER))
    })
    Set getById(Long id);

    @Select("select s.*, e.id as e_id, e.name as e_name, e.description as e_description from set s inner join exercise e on s.exercise_id = e.id where s.training_id = #{trainingId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "repeat", column = "repeat"),
            @Result(property = "duration", column = "duration"),
            @Result(property = "training.id", column = "training_id"),
            @Result(property = "exercise.id", column = "e_id"),
            @Result(property = "exercise.name", column = "e_name"),
            @Result(property = "exercise.description", column = "e_description")
    })
    List<Set> getTrainingSets(Long trainingId);

    @Insert("insert into set (repeat, duration, weight, exercise_id, training_id) values (#{repeat}, #{duration}, #{weight}, #{exercise.id}, #{training.id})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    Integer add(Set set);

    @UpdateProvider(type = SetSqlProvider.class, method = "update")
    Integer update(Set set);

    @Delete("delete from set where id = #{id}")
    Integer delete(Long id);
}
