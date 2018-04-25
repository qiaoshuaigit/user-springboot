package com.study.sgg.config;

import com.study.sgg.config.filter.MyFileter;
import com.study.sgg.config.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Arrays;

/**
 * @author shuaion 2018/4/24
 *
 *服务器相关得配置
 **/
@Configuration
public class MyServerConfiguration {


    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean();
        registrationBean.setListener(new MyListener());

        return registrationBean;
    }

    //给容器添加一个FilterRegistrationBean类型bean
    @Bean
    public FilterRegistrationBean myFilter(){

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setFilter(new MyFileter());

        registrationBean.addUrlPatterns("/hello","/myservlet","/myfilter");

        return registrationBean;
    }

    @Bean
    public ServletContextInitializer myServlet(){

       return new ServletContextInitializer() {
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                MyServlet myServlet = new MyServlet();

                servletContext.addServlet("myservlet",new MyServlet()).addMapping("/myservlet");
            }
        };
    }


}
