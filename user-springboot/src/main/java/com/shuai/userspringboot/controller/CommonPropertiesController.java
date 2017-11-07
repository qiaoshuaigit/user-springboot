package com.shuai.userspringboot.controller;

import com.shuai.userspringboot.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuaion 2017/11/6
 * 常规属性配置
 *
 * 在springboot中我们只需在application配置文件中
 * 定义属性,然后通过@Value注入即可。
 **/
@RestController
@RequestMapping("/properties")
public class CommonPropertiesController {

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Autowired
    private Author author;

    @RequestMapping("/index")
    public String index(){
        return "dataSourceUrl="+dataSourceUrl+",driverClassName="+driverClassName;
    }
    @RequestMapping("/author")
    public String author(){
        return "姓名:"+author.getName()+",年龄:"+author.getAge()+",性别"+author.getSex();
    }
}
