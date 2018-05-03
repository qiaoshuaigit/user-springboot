package com.study.sgg.mapper;

import com.study.sgg.model.Menu;

import java.util.List;

public interface MenuMapper {

    public List<Menu> getMenus();

    public void insertMenu(Menu menu);
}
