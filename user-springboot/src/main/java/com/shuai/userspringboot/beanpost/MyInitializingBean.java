package com.shuai.userspringboot.beanpost;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author shuaion 2018/5/15
 **/
//@Component
public class MyInitializingBean implements InitializingBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("=======afterPropertiesSet=======");
    }
}
