package com.me.controller;

import com.me.mybatis.entity.SysUser;
import com.me.service.SelectUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Logan Zhou on 2018-03-27.
 */
@RestController
public class RedisTestController {

    @Autowired
    private SelectUser selectUser;


    @GetMapping(value = "/redis/user/{id}")
    @Cacheable(value="cacheTest")
    public SysUser getUser(@PathVariable() Integer id) {
        SysUser user = selectUser.selectByPrimaryKey(id);
        return user;
    }
}
