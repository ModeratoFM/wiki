package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Test;
import com.jiawa.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Value("${test.hello:lulu}")
    private String hello;

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public  String Hello(){

        return  "hello world"+hello;
    }
    @PostMapping(value = "/hello/post")
    public String HelloPost(String name){
        return "hello world Post"+name;
    }

    @GetMapping("/test/list")
    public List<Test> list(){

        return  testService.list();
    }
}
