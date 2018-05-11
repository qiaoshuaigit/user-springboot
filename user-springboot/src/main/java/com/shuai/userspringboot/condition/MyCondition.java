package com.shuai.userspringboot.condition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author shuaion 2018/5/11
 **/
public class MyCondition implements Condition {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        logger.info("------MyCondition--here--------");

        return false;
    }
}
