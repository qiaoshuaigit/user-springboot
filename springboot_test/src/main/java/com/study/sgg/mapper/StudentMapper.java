package com.study.sgg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    @Select("select * from student")
    public List<Map<String,String>> getStudent();
}
