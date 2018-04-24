package com.shuai.userspringboot.controller;

import com.shuai.userspringboot.model.Student;
import com.shuai.userspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shuaion 2018/4/17
 **/
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @RequestMapping("/getAllStudent")
    public Object getAllStudent(){
        return  studentService.getStudents();
    }

    @ResponseBody
    @RequestMapping("/saveStudent")
    public Object saveStudent(Student student){
        studentService.saveStudent(student);
        return "SUCCESS";
    }

}
