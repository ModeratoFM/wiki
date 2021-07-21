package com.jiawa.wiki.service;
import com.jiawa.wiki.domain.Ebook_test;
import com.jiawa.wiki.mapper.Ebook_testMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Ebook_testService {

    private final Ebook_testMapper ebook_testMapper;


    public Ebook_testService(Ebook_testMapper ebook_testMapper) {
        this.ebook_testMapper = ebook_testMapper;
    }

    public List<Ebook_test> list(){

        return  ebook_testMapper.selectByExample(null);
    }



}
