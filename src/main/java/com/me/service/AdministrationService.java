package com.me.service;

import com.me.mybatis.entity.SysUser;

/**
 * Created by Logan Zhou on 2018-02-01.
 */
public interface AdministrationService {

    public SysUser getSysUserByUsername(String username);
}
