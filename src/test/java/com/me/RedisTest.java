package com.me;

import com.me.mybatis.entity.SysUser;
import com.me.mybatis.mapper.RedisMapper;
import com.me.service.redisService.RedisService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by Logan Zhou on 2018-03-26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisService redisService;


    @Test
    public void redisTest() throws Exception{
        stringRedisTemplate.opsForValue().set("aaa","111");
        Assert.assertEquals("111",stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void test2() throws Exception{
        SysUser sysUser = new SysUser();
        sysUser.setName("ddk");
        sysUser.setPassword("1234");
        sysUser.setState(1);
        ValueOperations<String,Object> operations = redisTemplate.opsForValue();

        operations.set("com.neox", sysUser);
        operations.set("com.neo.f", sysUser,1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        boolean exists = redisTemplate.hasKey("com.neoxh");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }
    }

    @Test
    public void get() throws Exception{
        SysUser sysUser = new SysUser();
        sysUser.setName("jack");
        sysUser.setUsername("kjk");
        redisService.add(sysUser.getName(),sysUser,10L);
        SysUser sysUser1 = redisService.get(sysUser.getName());
        Assert.assertNotNull(sysUser1);
    }
}
