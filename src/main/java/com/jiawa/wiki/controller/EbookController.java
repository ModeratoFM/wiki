package com.jiawa.wiki.controller;

import com.jiawa.wiki.req.EbookReq;
import com.jiawa.wiki.response.CommonResp;
import com.jiawa.wiki.response.EbookResp;
import com.jiawa.wiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    private  EbookService ebookService;

    public EbookController(EbookService ebookService) {
        this.ebookService = ebookService;
    }



    @GetMapping("/list")
    public CommonResp list(EbookReq req){

        CommonResp<List<EbookResp>> resp =new CommonResp<>();

        List<EbookResp> list =ebookService.list(req);
        resp.setContent(list);
        return  resp;
    }
}
