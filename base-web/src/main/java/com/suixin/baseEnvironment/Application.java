package com.suixin.baseEnvironment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.suixin.baseEnvironment")
//@ImportResource(locations = "classpath:spring/*.xml") 这个注解要注意如果没有xml文件SpringTest要报错哈！
@MapperScan(basePackages = "com.suixin.baseEnvironment.dao")
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

}
