package com.me.service.serviceImpl;

import com.me.mybatis.entity.SysUser;
import com.me.mybatis.mapper.SysUserMapper;
import com.me.service.SelectUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by Logan Zhou on 2018-03-27.
 */
@Service
public class SelectUserImpl implements SelectUser {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public SysUser selectByPrimaryKey(Integer id) {
        System.out.println("没有走缓存");
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
        return sysUser;
    }
}
