package com.jiawa.wiki.config;


import com.jiawa.wiki.interceptor.LogInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Resource
    LogInterceptor logInterceptor;  //注入一个过滤器
     //增加一个过滤器的方法
    public  void  addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(logInterceptor).addPathPatterns("/**").excludePathPatterns("/login");//"/**"这样写表示针对所有的请求
    }






}
