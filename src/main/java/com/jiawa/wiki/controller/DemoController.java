package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Demo;
import com.jiawa.wiki.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private  DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }



    @GetMapping("/list1")
    public List<Demo> list(){

        return  demoService.list();
    }
}
