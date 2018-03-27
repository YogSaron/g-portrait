package com.me;

import com.me.mybatis.entity.SysUser;
import com.me.mybatis.mapper.SysUserMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Logan Zhou on 2018-03-27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Controller
public class RedisCacheTest {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Cacheable(value="testallCache")
    @RequestMapping(value = "/redis/user/{userId}", method = RequestMethod.GET)
    public SysUser getUser(@PathVariable() Integer userId) {
        SysUser user = sysUserMapper.selectByPrimaryKey(userId);
        return user;
    }
}
