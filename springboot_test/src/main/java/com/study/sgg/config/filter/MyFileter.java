package com.study.sgg.config.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author shuaion 2018/4/24
 **/
public class MyFileter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFileter...init...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFileter...doFilter...");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("MyFileter...destroy...");

    }
}
