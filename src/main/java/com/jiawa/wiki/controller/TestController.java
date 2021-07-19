package com.jiawa.wiki.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public  String Hello(){

        return  "hello world";
    }
}
