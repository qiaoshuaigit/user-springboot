package com.shuai.userspringboot.beanpost;

import com.shuai.userspringboot.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author shuaion 2018/5/15
 **/
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (beanName.equals("user")){
            logger.info("===========BeanPostProcessor====前置处理器==========="+bean.toString());
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (beanName.equals("user")){
            logger.info("===========BeanPostProcessor=====后置处理器=========="+bean.toString());
        }

        return bean;
    }
}
