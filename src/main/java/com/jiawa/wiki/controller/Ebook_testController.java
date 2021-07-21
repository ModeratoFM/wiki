package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Ebook_test;
import com.jiawa.wiki.response.CommonResp;
import com.jiawa.wiki.service.Ebook_testService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ebook_test")
public class Ebook_testController {

    private  Ebook_testService ebook_testService;

    public Ebook_testController(Ebook_testService ebook_testService) {
        this.ebook_testService = ebook_testService;
    }



    @GetMapping("/list1")
    public CommonResp list(){

        CommonResp<List<Ebook_test>> resp =new CommonResp<>();
        List<Ebook_test> list =ebook_testService.list();
        resp.setContent(list);
        return  resp;
    }
}
