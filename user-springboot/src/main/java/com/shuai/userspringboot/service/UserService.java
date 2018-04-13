package com.shuai.userspringboot.service;

import com.shuai.userspringboot.dao.IUserDao;
import com.shuai.userspringboot.mapper.UserMapper;
import com.shuai.userspringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shuaion 2017/11/3
 **/
@Service
public class UserService {

    @Autowired
    private IUserDao userDao;
    @Autowired
    private UserMapper userMapper;


    public List<User> getUsers(){
        return userDao.getUsers();
    }

    public void insert(User user){
        userMapper.insert(user);
    }

    public User getUserById(Integer id){
       return userMapper.selectByPrimaryKey(id);
    }
}
