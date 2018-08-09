package com.epam.fitnesstracker.dao;

import com.epam.fitnesstracker.domain.Set;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SetDao {

    //TODO @One exercise
    @Select("select * from set where id = #{id}")
    Set getById(Long id);

    //TODO add join with exercise
    @Select("select * from set where training_id = #{trainingId}")
    List<Set> getTrainingSets(Long trainingId);

    @Insert("insert into set (repeat, duration, weight, exercise_id, training_id) values (#{repeat}, #{duration}, #{weight}, #{exercise.id}, #{training.id})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    Integer add(Set set);

    //TODO add dynamic SQL
    @Update("update set set repeat = #{repeat}, duration = #{duration}, weight = #{weight}, exercise_id = #{exercise.id}, training_id = #{training.id} where id = #{id}")
    Integer update(Set set);

    @Delete("delete from set where id = #{id}")
    Integer delete(Long id);
}
