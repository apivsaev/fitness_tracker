package com.epam.fitnesstracker.dao;

import com.epam.fitnesstracker.dao.providers.TrainingSqlProvider;
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

    @Select("select * from training where user_id = #{userId}")
    List<Training> getUserTrainings(Long userId);

    @Select("select * from training where id = #{id}")
    Training getById(Long id);

    @Insert("insert into training (date, calories, user_id) values (#{date}, #{calories}, #{user.id}")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    Long add(Training training);

    @UpdateProvider(type = TrainingSqlProvider.class, method = "update")
    Integer update(Training training);

    @Delete("delete from training where id = #{id}")
    Integer delete(Long id);
}
