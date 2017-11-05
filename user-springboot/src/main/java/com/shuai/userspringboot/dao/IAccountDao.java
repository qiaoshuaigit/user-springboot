package com.shuai.userspringboot.dao;

import com.shuai.userspringboot.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountDao extends JpaRepository<Account,Integer> {


}
