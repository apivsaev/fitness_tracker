package com.epam.fitnesstracker.dao;

import com.epam.fitnesstracker.domain.Set;
import com.epam.fitnesstracker.domain.Training;
import com.epam.fitnesstracker.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface TrainingDao {

    @Select("select * from training where id = #{training_id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "sets", javaType = List.class, column = "id", many = @Many(select = "getTrainingSets", fetchType = FetchType.EAGER)),
            //@Result(property = "user", javaType = User.class, column = "user_id", one = @One(select = "getUser", fetchType = FetchType.EAGER))
    })
    Training getTrainingWithSets(Long training_id);

    @Select("select * from set where training_id = #{training_id}")
    List<Set> getTrainingSets(Long training_id);

//    @Select("select * from user where id = 1")
//    User getUser(Long id);
}
