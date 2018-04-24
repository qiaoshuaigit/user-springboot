package com.study.sgg.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Iterator;
import java.util.Map;

/**
 * @author shuaion 2018/4/24
 *
 * springbooy中springmvc功能扩展
 *
 * 添加拦截器 或者 资源映射等
 *
 * 参考springboot文档 27.1节
 *
 **/
@Configuration
public class MyMvcConfiguration extends WebMvcConfigurerAdapter {





    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addWebRequestInterceptor(new WebRequestInterceptor() {
            @Override
            public void preHandle(WebRequest request) throws Exception {
                Iterator<String> headers = request.getHeaderNames();

                while (headers.hasNext()){
                    System.out.println("preHandle--header="+headers.next());
                }


                Map map = request.getParameterMap();

                System.out.println("map="+map);
            }

            @Override
            public void postHandle(WebRequest request, @Nullable ModelMap model) throws Exception {

                Iterator<String> headers = request.getHeaderNames();

                while (headers.hasNext()){
                    System.out.println("postHandle--header="+headers.next());
                }
            }

            @Override
            public void afterCompletion(WebRequest request, @Nullable Exception ex) throws Exception {

                Iterator<String> headers = request.getHeaderNames();

                while (headers.hasNext()){
                    System.out.println("afterCompletion--header="+headers.next());
                }
            }
        });

        super.addInterceptors(registry);
    }

}
