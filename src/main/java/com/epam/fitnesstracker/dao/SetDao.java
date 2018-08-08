package com.epam.fitnesstracker.dao;

import com.epam.fitnesstracker.domain.Set;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetDao {

    @Select("select * from set where training_id = #{trainingId}")
    List<Set> getTrainingSets(Long trainingId);
}
