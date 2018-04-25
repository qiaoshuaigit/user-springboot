package com.study.sgg.config.filter;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author shuaion 2018/4/25
 *
 * 使用如下注解开启filter
 *
 * 73.1.2 Add Servlets, Filters, and Listeners using classpath scanning

 @WebServlet, @WebFilter, and @WebListener annotated classes can be automatically
 registered with an embedded servlet container by annotating a @Configuration class
 with @ServletComponentScan and specifying the package(s) containing the components
 that you want to register. By default,
 @ServletComponentScan will scan from the package of the annotated class.
 *
 **/
@WebFilter(filterName = "myFilter2",urlPatterns = "/myFilter2/*")
@Configuration("myFilter2")
@ServletComponentScan
public class MyFilter1 implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("-----MyFilter1----init-----");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("-----MyFilter1----doFilter-----");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("-----MyFilter1----destroy-----");
    }
}
