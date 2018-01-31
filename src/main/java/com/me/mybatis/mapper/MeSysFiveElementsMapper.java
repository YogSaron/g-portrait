package com.me.mybatis.mapper;

import com.me.mybatis.entity.MeSysFiveElements;

public interface MeSysFiveElementsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MeSysFiveElements record);

    int insertSelective(MeSysFiveElements record);

    MeSysFiveElements selectByPrimaryKey(Integer id);

    //根据parentId查找对象
    MeSysFiveElements selectByParentId(Integer id);

    int updateByPrimaryKeySelective(MeSysFiveElements record);

    int updateByPrimaryKey(MeSysFiveElements record);
}