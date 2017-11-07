package com.shuai.userspringboot.mapper;

import com.shuai.userspringboot.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface AccountMapper  {

     int update(@Param("money") String money, @Param("id") int id);
     List<Account> getAccountByPage();
}
