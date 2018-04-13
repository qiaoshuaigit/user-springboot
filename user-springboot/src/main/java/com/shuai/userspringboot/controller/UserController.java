package com.shuai.userspringboot.controller;

import com.shuai.userspringboot.model.User;
import com.shuai.userspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shuaion 2017/11/3
 **/
@RequestMapping("/user")
@Controller
public class UserController extends SpringBootServletInitializer {

    @Autowired
    private UserService userService;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UserController.class);
    }
    @ResponseBody
    @RequestMapping("/getUsers")
    public Object getUsers(){
        return userService.getUsers().toString();
    }
    @RequestMapping("/insert")
    public Object insert(User user){
        userService.insert(user);
        return "success";
    }
    @RequestMapping("/getUserById")
    public Object getUserById(Integer id){
        return userService.getUserById(id);
    }


    @RequestMapping("/goindex")
    public String index(){
        return "index";
    }
}
