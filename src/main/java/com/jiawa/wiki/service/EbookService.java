package com.jiawa.wiki.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.domain.EbookExample;
import com.jiawa.wiki.mapper.EbookMapper;
import com.jiawa.wiki.req.EbookReq;
import com.jiawa.wiki.response.EbookResp;
import com.jiawa.wiki.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;


@Service
public class EbookService {
    public static final Logger LOG= LoggerFactory.getLogger(EbookService.class);

    private final EbookMapper ebookMapper;


    public EbookService(EbookMapper ebookMapper) {
        this.ebookMapper = ebookMapper;
    }

    public List<EbookResp> list(EbookReq req){
        //通用写法
        EbookExample ebookExample= new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getName())){
            criteria.andNameLike("%"+req.getName()+"%");


        }
        PageHelper.startPage(1,3);
        List<Ebook> ebooklist=ebookMapper.selectByExample(ebookExample);

        PageInfo<Ebook> pageInfo = new PageInfo<>(ebooklist);
        LOG.info("总行数:{}",pageInfo.getTotal());
        LOG.info("总页数:{}",pageInfo.getPages());



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
