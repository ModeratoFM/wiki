package com.jiawa.wiki.mapper;

import com.jiawa.wiki.domain.Ebook_test;
import com.jiawa.wiki.domain.Ebook_testExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Ebook_testMapper {
    long countByExample(Ebook_testExample example);

    int deleteByExample(Ebook_testExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Ebook_test record);

    int insertSelective(Ebook_test record);

    List<Ebook_test> selectByExample(Ebook_testExample example);

    Ebook_test selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Ebook_test record, @Param("example") Ebook_testExample example);

    int updateByExample(@Param("record") Ebook_test record, @Param("example") Ebook_testExample example);

    int updateByPrimaryKeySelective(Ebook_test record);

    int updateByPrimaryKey(Ebook_test record);
}