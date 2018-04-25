package com.study.sgg.config;

import com.study.sgg.config.filter.MyFileter;
import com.study.sgg.config.listener.MyListener;
import com.study.sgg.config.servlet.MyServlet;
import com.study.sgg.config.servlet.Myservlet1;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author shuaion 2018/4/24
 *
 *服务器相关得配置
 *
 * If convention-based mapping is not flexible enough you can use the
 * ServletRegistrationBean, FilterRegistrationBean and ServletListenerRegistrationBean
 * classes for complete control.
 **/
@Configuration
public class MyServerConfiguration {

    @Bean
    public ServletRegistrationBean myservlet1(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new Myservlet1());
        servletRegistrationBean.addUrlMappings("/myservlet1");
        return servletRegistrationBean;
    }

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
