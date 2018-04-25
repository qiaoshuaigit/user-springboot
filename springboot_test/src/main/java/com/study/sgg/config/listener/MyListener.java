package com.study.sgg.config.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author shuaion 2018/4/25
 **/
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("-----MyListener---contextInitialized----");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("-----MyListener---contextDestroyed----");

    }
}
