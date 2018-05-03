package com.study.sgg.repository;

import com.study.sgg.model.Element;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shuaion 2018/5/3
 **/
//继承JpaRepository 分页 排序 增删改查 功能
public interface ElementRepository extends JpaRepository<Element,Integer> {
}
