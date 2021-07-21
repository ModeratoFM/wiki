package com.jiawa.wiki.service;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.domain.EbookExample;
import com.jiawa.wiki.mapper.EbookMapper;
import com.jiawa.wiki.req.EbookReq;
import com.jiawa.wiki.response.EbookResp;
import com.jiawa.wiki.util.CopyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EbookService {

    private final EbookMapper ebookMapper;


    public EbookService(EbookMapper ebookMapper) {
        this.ebookMapper = ebookMapper;
    }

    public List<EbookResp> list(EbookReq req){
        //通用写法
        EbookExample ebookExample= new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();

        criteria.andNameLike("%"+req.getName()+"%");

        List<Ebook> ebooklist=ebookMapper.selectByExample(ebookExample);
      /*

        //创建一个返回类型是EbookResp的对象
        List<EbookResp> respList =new ArrayList<>();
        //遍历ebooklist，获取数据赋值给ebookResp对象
        for (Ebook ebook : ebooklist) {
          //  EbookResp ebookResp = new EbookResp();
          //  BeanUtils.copyProperties(ebook,ebookResp);
            // ebookResp.setId(ebook.getId());
           // ebookResp.setId(123L); 测试用
            //对象复制
            EbookResp ebookResp = CopyUtil.copy(ebook, EbookResp.class);
            respList.add(ebookResp);

        }

        */

        //使用封装好的工具类代替上面一大段代码，列表复制
        List<EbookResp> list = CopyUtil.copyList(ebooklist, EbookResp.class);
        return list;
    }



}
