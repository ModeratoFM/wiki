package com.jiawa.wiki.service;
import com.jiawa.wiki.domain.Demo;
import com.jiawa.wiki.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class DemoService {

    private final DemoMapper demoMapper;


    public DemoService(DemoMapper demoMapper) {
        this.demoMapper = demoMapper;
    }

    public List<Demo> list(){

        return  demoMapper.selectByExample(null);
    }



}
