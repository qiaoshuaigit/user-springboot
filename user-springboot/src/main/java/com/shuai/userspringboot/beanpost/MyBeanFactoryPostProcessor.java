package com.shuai.userspringboot.beanpost;

import com.shuai.userspringboot.model.Author;
import com.shuai.userspringboot.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author shuaion 2018/5/15
 *         <p/>
 *         All bean definitions will have been loaded, but no beans will have been instantiated yet.
 *         所有的bean definitions都已经被加载,但这些bean还没有被实例化
 *         <p/>
 *         也就是说这些bean还没实例化之前 我们可以进行处理
 *
 *         通过参数beanFactory可以获取bean的定义信息，并可以修改bean的定义信息。这点是和BeanPostProcessor最大区别
 **/
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("user");

        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.add("address", "美国");


        logger.info("===========BeanFactoryPostProcessor======" + propertyValues);
    }
}
