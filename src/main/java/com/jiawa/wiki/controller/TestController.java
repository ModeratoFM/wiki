package com.jiawa.wiki.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TestController {
    @Value("${test.hello:lulu}")
    private String hello;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public  String Hello(){

        return  "hello world"+hello;
    }
    @PostMapping(value = "/hello/post")
    public String HelloPost(String name){
        return "hello world Post"+name;
    }
}
