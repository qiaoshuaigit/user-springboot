package com.shuai.userspringboot.service;

import com.shuai.userspringboot.dao.StudentRepository;
import com.shuai.userspringboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shuaion 2018/4/17
 **/
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void saveStudent(Student s){
        studentRepository.save(s);
    }

}
