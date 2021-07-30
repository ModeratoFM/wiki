package com.jiawa.wiki.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.domain.EbookExample;
import com.jiawa.wiki.mapper.EbookMapper;
import com.jiawa.wiki.req.EbookReq;
import com.jiawa.wiki.req.EbookSaveReq;
import com.jiawa.wiki.response.EbookResp;
import com.jiawa.wiki.response.PageResp;
import com.jiawa.wiki.util.CopyUtil;
import com.jiawa.wiki.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;


@Service
public class EbookService {
    public static final Logger LOG= LoggerFactory.getLogger(EbookService.class);
    @Resource
    private  EbookMapper ebookMapper;

    @Resource
    private  SnowFlake snowFlake;



    public EbookService(EbookMapper ebookMapper) {
        this.ebookMapper = ebookMapper;
    }

    public PageResp<EbookResp> list(EbookReq req){
        //通用写法
        EbookExample ebookExample= new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getName())){
            criteria.andNameLike("%"+req.getName()+"%");
        }
        // 请求参数：一个是页码，一个是每页的条数,使用req.getPage()、 req.getSize()不要写死，变成动态的
        PageHelper.startPage(req.getPage(),req.getSize());
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
        PageResp<EbookResp> pageResp=new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }
    /*
    * 保存
    * */
    public void save(EbookSaveReq req){
        //将请求参数，把他变成我们的实体，再更新进来
        Ebook ebook=CopyUtil.copy(req,Ebook.class);
        if(ObjectUtils.isEmpty(req.getId())){
            //新增
            ebook.setId(snowFlake.nextId());

            ebookMapper.insert(ebook);
        }else {
            //更新
            ebookMapper.updateByPrimaryKey(ebook);
        }




    }

    public void delete(Long id){

        ebookMapper.deleteByPrimaryKey(id);

    }





}
