package com.me.service.redisService;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.me.mybatis.entity.SysUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Logan Zhou on 2018-03-27.
 */
@Repository
public class RedisService {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void add(String key, SysUser user, Long time) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        stringRedisTemplate.opsForValue().set(key, mapper.writeValueAsString(user), time, TimeUnit.MINUTES);
    }

    public void add(String key, List<SysUser> users, Long time) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        String src = mapper.writeValueAsString(users);
        stringRedisTemplate.opsForValue().set(key, src, time, TimeUnit.MINUTES);
    }

    public SysUser get(String key) throws Exception{
        String source = stringRedisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(source)) {
            return new ObjectMapper().readValue(source, SysUser.class);
        }
        return null;
    }

    public List<SysUser> getSysUserList(String key) throws IOException{
        String source = stringRedisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(source)) {
            return new ObjectMapper().readValue(source, new TypeReference<List<SysUser>>(){});
        }
        return null;
    }

    public void delete(String key) {
        stringRedisTemplate.opsForValue().getOperations().delete(key);
    }
}
