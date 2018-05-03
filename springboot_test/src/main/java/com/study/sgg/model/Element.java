package com.study.sgg.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author shuaion 2018/5/3
 **/
@Entity//指定是一个实体类
@Table//来指定和哪个表对应
public class Element implements Serializable{

    @Id//这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//这是一个自增
    private int id;
    @Column(name = "menu_id")//这是对应数据库字段
    private String menuId;
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;
    @Column(name = "status")
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
