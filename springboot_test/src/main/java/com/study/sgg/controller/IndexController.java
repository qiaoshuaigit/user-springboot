package com.study.sgg.controller;

import com.study.sgg.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shuaion 2018/4/28
 **/
@Controller
public class IndexController {

    @Autowired
    private StudentMapper studentMapper;

    @ResponseBody
    @RequestMapping("/getStudent")
    public Object getStudent(){
        return studentMapper.getStudent();
    }

}
