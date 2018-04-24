package com.study.sgg.config;

import com.study.sgg.config.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author shuaion 2018/4/24
 *
 *服务器相关得配置
 **/
@Configuration
public class MyServerConfiguration {

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
