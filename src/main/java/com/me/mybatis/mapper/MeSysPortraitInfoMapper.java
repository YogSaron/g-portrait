package com.me.mybatis.mapper;

import com.me.mybatis.entity.MeSysPortraitInfo;

public interface MeSysPortraitInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MeSysPortraitInfo record);

    int insertSelective(MeSysPortraitInfo record);

    MeSysPortraitInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MeSysPortraitInfo record);

    int updateByPrimaryKey(MeSysPortraitInfo record);
}