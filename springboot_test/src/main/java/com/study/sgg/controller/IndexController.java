package com.study.sgg.controller;

import com.auto.shuai.service.HelloService;
import com.study.sgg.mapper.MenuMapper;
import com.study.sgg.mapper.StudentMapper;
import com.study.sgg.mapper.UserMapper;
import com.study.sgg.model.Element;
import com.study.sgg.model.Menu;
import com.study.sgg.repository.ElementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author shuaion 2018/4/28
 **/
@Controller
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private ElementRepository elementRepository;

    @Autowired
    private HelloService helloService;

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
        logger.trace("logger.trace");
        logger.debug("logger.debug");
        logger.info("logger.info");
        logger.warn("logger.warn");
        logger.error("logger.error");

        return menuMapper.getMenus();
    }

    @ResponseBody
    @RequestMapping("/insertMenu")
    public Object insertMenu(Menu menu){
        menuMapper.insertMenu(menu);
        return menuMapper.getMenus();
    }
    @ResponseBody
    @RequestMapping("/getElement")
    public Object getElement(Integer id){
        return elementRepository.findById(id);
    }
    @ResponseBody
    @RequestMapping("/insertElement")
    public Object insertElement(Element element){
        return elementRepository.save(element);
    }

    @ResponseBody
    @RequestMapping("/hello")
    public Object sayHello(){
        return helloService.sayHello("shuaige");
    }
}
