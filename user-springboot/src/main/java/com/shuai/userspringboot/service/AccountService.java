package com.shuai.userspringboot.service;

import com.github.pagehelper.PageHelper;
import com.shuai.userspringboot.dao.IAccountDao;
import com.shuai.userspringboot.mapper.AccountMapper;
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

    @Autowired
    private AccountMapper accountMapper;

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


    public int update(String money,int id){
        logger.info("money="+money+",id="+id);
       return accountMapper.update(money,id);
    }

    public List<Account> getAccountByPage(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Account> accounts = accountMapper.getAccountByPage();
        return accounts;
    }

}
