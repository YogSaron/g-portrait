package com.me.service;

import com.me.mybatis.entity.SysUser;

/**
 * Created by Logan Zhou on 2018-03-27.
 */
public interface SelectUser {

    public SysUser selectByPrimaryKey(Integer id);
}
