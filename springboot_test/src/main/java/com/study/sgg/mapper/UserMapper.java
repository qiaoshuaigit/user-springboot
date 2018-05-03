package com.study.sgg.mapper;

import com.study.sgg.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    public List<User> getUsers();
}
