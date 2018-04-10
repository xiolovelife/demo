package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by xiaoxin on 2018/3/26 .
 */
public interface UserMapper {

    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "name",  column = "u_name"),
            @Result(property = "age", column = "u_age")
    })
    List<User> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "name",  column = "u_name"),
            @Result(property = "age", column = "u_age")
    })
    User getOne(Long id);

    @Insert("INSERT INTO users(u_name,u_age) VALUES (#{name}, #{age})")
    void insert(User user);

    @Update("UPDATE users SET u_name=#{name},u_age=#{age} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);
}
