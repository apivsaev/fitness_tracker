package com.epam.fitnesstracker.dao;

import com.epam.fitnesstracker.domain.Exercise;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExerciseDao {

    @Select("select * from exercise")
    List<Exercise> get();

    @Select("select * from exercise where id = #{id}")
    Exercise getById(Long id);

    @Insert("insert into exercise (name, description) values (#{name}, #{description})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer add(Exercise exercise);

    @Update("update exercise set name = #{name}, description = #{description} where id = #{id}")
    Integer update(Exercise exercise);

    @Delete("delete from exercise where id = #{id}")
    Integer delete(Long id);

}
