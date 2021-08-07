package com.jiawa.wiki.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiawa.wiki.domain.User;
import com.jiawa.wiki.domain.UserExample;
import com.jiawa.wiki.excepion.BusinessException;
import com.jiawa.wiki.excepion.BusinessExceptionCode;
import com.jiawa.wiki.mapper.UserMapper;
import com.jiawa.wiki.req.UserReq;
import com.jiawa.wiki.req.UserSaveReq;
import com.jiawa.wiki.response.UserResp;
import com.jiawa.wiki.response.PageResp;
import com.jiawa.wiki.util.CopyUtil;
import com.jiawa.wiki.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;


@Service
public class UserService {
    public static final Logger LOG= LoggerFactory.getLogger(UserService.class);
    @Resource
    private  UserMapper userMapper;

    public UserService() {
    }

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Resource
    private  SnowFlake snowFlake;




    public PageResp<UserResp> list(UserReq req){
        //通用写法
        UserExample userExample= new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getLoginName())){
            criteria.andNameLike("%"+req.getLoginName()+"%");
        }
        // 请求参数：一个是页码，一个是每页的条数,使用req.getPage()、 req.getSize()不要写死，变成动态的
        PageHelper.startPage(req.getPage(),req.getSize());
        List<User> userlist=userMapper.selectByExample(userExample);

        PageInfo<User> pageInfo = new PageInfo<>(userlist);
        LOG.info("总行数:{}",pageInfo.getTotal());
        LOG.info("总页数:{}",pageInfo.getPages());


        /*

        //创建一个返回类型是UserResp的对象
        List<UserResp> respList =new ArrayList<>();
        //遍历userlist，获取数据赋值给userResp对象
        for (User user : userlist) {
          //  UserResp userResp = new UserResp();
          //  BeanUtils.copyProperties(user,userResp);
            // userResp.setId(user.getId());
           // userResp.setId(123L); 测试用
            //对象复制
            UserResp userResp = CopyUtil.copy(user, UserResp.class);
            respList.add(userResp);

        }

        */
        //使用封装好的工具类代替上面一大段代码，列表复制
        List<UserResp> list = CopyUtil.copyList(userlist, UserResp.class);
        PageResp<UserResp> pageResp=new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }
    /*
    * 保存
    * */
    public void save(UserSaveReq req){



        //将请求参数，把他变成我们的实体，再更新进来
        User user=CopyUtil.copy(req,User.class);
        if(ObjectUtils.isEmpty(req.getId())){


           User userDB= selectByLoginName(req.getLoginName());
           if (ObjectUtils.isEmpty(userDB)){

               //新增
               user.setId(snowFlake.nextId());
               userMapper.insert(user);

           }else {

               //用户名已存在
               throw new BusinessException(BusinessExceptionCode.USER_LOGIN_NAME_EXIST);
           }

        }else {
            //更新
            user.setLoginName(null);
            userMapper.updateByPrimaryKeySelective(user);
        }




    }

    public void delete(Long id){

        userMapper.deleteByPrimaryKey(id);

    }

    public User  selectByLoginName(String loginName){


        //通用写法
        UserExample userExample= new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameLike(loginName);
        List<User> userlist=userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(userlist)){

            return null;
        }else {
             //否则返回第一条，因为只有一条
            return userlist.get(0);
        }



    }




}
