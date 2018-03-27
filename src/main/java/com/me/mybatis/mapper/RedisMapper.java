package com.me.mybatis.mapper;

import com.me.mybatis.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

/**
 * Created by Logan Zhou on 2018-03-26.
 */
@Mapper
@CacheConfig(cacheNames = "users")
public interface RedisMapper {
    @Select("select * from sys_user where id =#{id}")
    @Cacheable(key ="#p0")
    SysUser findById(@Param("id") Integer id);
}
