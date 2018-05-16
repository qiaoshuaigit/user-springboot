package com.shuai.userspringboot.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * bean 初始化过程
 * <p/>
 * 1.执行BeanFactoryPostProcessor中postProcessBeanFactory方法
 * 2.执行 构造函数 方法
 * 3.执行 设置属性 方法
 * 4.执行 BeanPostProcessor前置处理器
 * 5.执行 @PostConstruct = init()
 * //6.执行 InitializingBean中afterPropertiesSet方法
 * 7.执行 BeanPostProcessor 后置处理器
 * <p/>
 * <p/>
 * 关于在spring  容器初始化 bean 和销毁前所做的操作定义方式有三种：
 * <p/>
 * 第一种：通过@PostConstruct 和 @PreDestroy 方法 实现初始化和销毁bean之前进行的操作
 * <p/>
 * 第二种是：通过 在xml中定义init-method 和  destory-method方法
 * <p/>
 * 第三种是： 通过bean实现InitializingBean和 DisposableBean接口
 */
//@Component
@Configuration
public class User implements InitializingBean, DisposableBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public User() {
        logger.info("====user构造函数初始化====");
    }

    public User(String address) {
        this.address = address;
    }

    @Bean
    public User user1() {
        logger.info("=======@Bean===user1=====");
        return new User("朝鲜");
    }

    private Integer id;

    private String name;

    private Integer age;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        logger.info("==setId==" + id);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        logger.info("==setName==" + name);
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        logger.info("==setAge==" + age);
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        logger.info("==setAddress==" + address);
        this.address = address == null ? null : address.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("======= InitializingBean - afterPropertiesSet === AbstractAutowireCapableBeanFactory 中 initializeBean >  invokeInitMethods 【 ((InitializingBean) bean).afterPropertiesSet() 】中调用 =======");
    }

    @PostConstruct //初始化方法的注解方式  等同与init-method=init
    public void init() {
        logger.info("==== @PostConstruct = init() === ");
    }

    @PreDestroy //容器销毁时执行
    public void destory() {
        logger.info("====== @PreDestroy == destory ==========");
    }

    @Override
    public void destroy() throws Exception {
        logger.info("====== DisposableBean ==== destroy ======");
    }
}