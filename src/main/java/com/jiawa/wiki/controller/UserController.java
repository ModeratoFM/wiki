package com.jiawa.wiki.controller;

import com.jiawa.wiki.req.UserReq;
import com.jiawa.wiki.req.UserSaveReq;
import com.jiawa.wiki.response.CommonResp;
import com.jiawa.wiki.response.UserResp;
import com.jiawa.wiki.response.PageResp;
import com.jiawa.wiki.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private  UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/list")
    public CommonResp list(@Valid @RequestBody UserReq req){

        CommonResp<PageResp<UserResp>> resp =new CommonResp<>();

        PageResp<UserResp> list =userService.list(req);
        resp.setContent(list);
        return  resp;
    }
    @PostMapping ("/save")
    public CommonResp save(@RequestBody  UserSaveReq req){

        CommonResp resp =new CommonResp<>();

        userService.save(req);
        return  resp;
    }

    @PostMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id){
        CommonResp resp = new CommonResp<>();

        userService.delete(id);
        return  resp;



    }



}
