package com.jiawa.wiki.controller;

import com.jiawa.wiki.req.EbookReq;
import com.jiawa.wiki.req.EbookSaveReq;
import com.jiawa.wiki.response.CommonResp;
import com.jiawa.wiki.response.EbookResp;
import com.jiawa.wiki.response.PageResp;
import com.jiawa.wiki.service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    private  EbookService ebookService;

    public EbookController(EbookService ebookService) {
        this.ebookService = ebookService;
    }



    @GetMapping("/list")
    public CommonResp list(@Valid @RequestBody EbookReq req){

        CommonResp<PageResp<EbookResp>> resp =new CommonResp<>();

        PageResp<EbookResp> list =ebookService.list(req);
        resp.setContent(list);
        return  resp;
    }
    @PostMapping ("/save")
    public CommonResp save(@RequestBody  EbookSaveReq req){

        CommonResp resp =new CommonResp<>();

        ebookService.save(req);
        return  resp;
    }

    @PostMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id){
        CommonResp resp = new CommonResp<>();

        ebookService.delete(id);
        return  resp;



    }



}
