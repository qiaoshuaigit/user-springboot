package com.study.sgg.controller;

import com.study.sgg.mapper.MenuMapper;
import com.study.sgg.mapper.StudentMapper;
import com.study.sgg.mapper.UserMapper;
import com.study.sgg.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shuaion 2018/4/28
 **/
@Controller
public class IndexController {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @ResponseBody
    @RequestMapping("/getStudent")
    public Object getStudent(){
        return studentMapper.getStudent();
    }

    @ResponseBody
    @GetMapping("/getUser")
    public Object getUser(){
        return userMapper.getUsers();
    }

    @ResponseBody
    @GetMapping("/getMenu")
    public Object getMenu(){
        return menuMapper.getMenus();
    }

    @ResponseBody
    @RequestMapping("/insertMenu")
    public Object insertMenu(Menu menu){
        menuMapper.insertMenu(menu);
        return menuMapper.getMenus();
    }
}
