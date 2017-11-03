package com.shuai.userspringboot.dao;

import com.shuai.userspringboot.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IUserDao {

    @Select("select id,name,age,address from user")
    List<User> getUsers();
}
