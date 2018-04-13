package com.shuai.userspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author shuaion 2017/11/3
 **/
@RestController("hello")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public Object toIndex(){
        ModelAndView mv = new ModelAndView("index");

        return mv;
    }
}
