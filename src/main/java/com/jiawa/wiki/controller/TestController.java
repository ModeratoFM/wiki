package com.jiawa.wiki.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TestController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public  String Hello(){

        return  "hello world";
    }
    @PostMapping(value = "/hello/post")
    public String HelloPost(String name){
        return "hello world Post"+name;
    }
}
