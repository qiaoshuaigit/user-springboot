package com.study.sgg.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shuaion 2018/5/2
 **/
//第二种方式 使用@MapperScan注解方式扫描包
@MapperScan(value = "com.study.sgg.mapper")
@Configuration
public class MybatisConfigCustomizer {

    //配置驼峰
    //如 实体类userName 可映射数据库 user_name
    @Bean
    public ConfigurationCustomizer myConfigCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
