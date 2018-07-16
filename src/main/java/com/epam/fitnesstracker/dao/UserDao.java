package com.epam.fitnesstracker.dao;

import com.epam.fitnesstracker.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from user where id = #{id}")
    User getById(Integer id);
}
