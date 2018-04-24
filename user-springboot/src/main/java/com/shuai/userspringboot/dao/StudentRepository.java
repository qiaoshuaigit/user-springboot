package com.shuai.userspringboot.dao;

import com.shuai.userspringboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shuaion 2018/4/17
 **/
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
