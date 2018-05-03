package com.study.sgg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

//第一种方式 使用@Mapper注解
//@Mapper
public interface StudentMapper {

    @Select("select * from student")
    public List<Map<String,String>> getStudent();
}
