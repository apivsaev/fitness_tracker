package com.epam.fitnesstracker.dao;

import com.epam.fitnesstracker.domain.Training;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface TrainingDao {

    @Select("select * from training where id = #{training_id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "sets", javaType = List.class, column = "id", many = @Many(select = "com.epam.fitnesstracker.dao.SetDao.getTrainingSets", fetchType = FetchType.EAGER)),
    })
    Training getTrainingWithSets(Long training_id);
}
