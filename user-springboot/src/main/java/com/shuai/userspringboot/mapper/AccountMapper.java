package com.shuai.userspringboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Mapper
public interface AccountMapper  {

     int update(@Param("money") String money, @Param("id") int id);
}
