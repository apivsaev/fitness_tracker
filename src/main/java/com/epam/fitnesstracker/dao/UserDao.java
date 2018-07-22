package com.epam.fitnesstracker.dao;

import com.epam.fitnesstracker.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from user")
    List<User> getUsers();

    @Select("select * from user where id = #{id}")
    User getById(Long id);

    @Insert("insert into user (name, age) values (#{name}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Long addUser(User user);
}
