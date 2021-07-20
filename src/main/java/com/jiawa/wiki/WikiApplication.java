package com.jiawa.wiki;

import org.apache.commons.logging.Log;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.Mapping;

@SpringBootApplication
@MapperScan("com.jiawa.wiki.mapper")
public class WikiApplication {

    private static final Logger LOG = LoggerFactory.getLogger(WikiApplication.class);

    public static void main(String[] args) {

        SpringApplication app=  new SpringApplication(WikiApplication.class);

        System.out.println("hello world" );
        Environment env =app.run(args).getEnvironment();
        LOG.info("启动成功");
        LOG.info("地址：http://127.0.0.1:{}");
        LOG.info(env.getProperty("server.port"));





    }

}
