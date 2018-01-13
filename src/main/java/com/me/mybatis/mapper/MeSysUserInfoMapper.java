package com.me.mybatis.mapper;

import com.me.mybatis.entity.MeSysUserInfo;

public interface MeSysUserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MeSysUserInfo record);

    int insertSelective(MeSysUserInfo record);

    MeSysUserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MeSysUserInfo record);

    int updateByPrimaryKey(MeSysUserInfo record);
}