package com.study.sgg.config.durid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shuaion 2018/5/2
 **/
@Configuration
public class DruidConfig {


    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource durid() {

        return new DruidDataSource();
    }

    //配置druid监控
    //配置servlet
    @Bean
    public ServletRegistrationBean startViewServlet() {

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        Map<String, String> param = new HashMap<>();

        param.put("loginUsername", "admin");
        param.put("loginPassword", "123456");

        servletRegistrationBean.setInitParameters(param);

        return servletRegistrationBean;
    }

    //配置filter
    @Bean
    public FilterRegistrationBean webStartFilter() {

        FilterRegistrationBean filterBean = new FilterRegistrationBean<>(new WebStatFilter());
        Map<String, String> param = new HashMap<>();
        param.put("exclusions","*.js,*.css,/druid/*");

        filterBean.setInitParameters(param);

        filterBean.setUrlPatterns(Arrays.asList("/*"));

        return filterBean;
    }

}
