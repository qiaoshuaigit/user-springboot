package com.shuai.userspringboot.service;

import com.shuai.userspringboot.dao.IAccountDao;
import com.shuai.userspringboot.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shuaion 2017/11/5
 **/
@Service
public class AccountService {

    private Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private IAccountDao accountDao;

    public void insert(String name,String money){
        logger.info("name="+name+",money="+money);
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        accountDao.save(account);
    }

    public List<Account> getAllAccount() {
        return accountDao.findAll();
    }

}
