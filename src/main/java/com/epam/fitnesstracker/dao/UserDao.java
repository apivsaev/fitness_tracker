package com.epam.fitnesstracker.dao;

import com.epam.fitnesstracker.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from user")
    List<User> get();

    @Select("select * from user where id = #{id}")
    User getById(Long id);

    @Insert("insert into user (name, age) values (#{name}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer add(User user);

    @Delete("delete from user where id = #{id}")
    Integer delete(Long id);

    @Update("update user set name = #{name}, age = #{age} where id = #{id}")
    Integer update(User user);
}
