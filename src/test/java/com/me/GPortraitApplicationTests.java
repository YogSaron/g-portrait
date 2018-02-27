package com.me;

import com.me.mybatis.entity.MeSysUserInfo;
import com.me.mybatis.entity.SysUser;
import com.me.mybatis.mapper.MeSysUserInfoMapper;
import com.me.mybatis.mapper.SysUserMapper;
import com.me.mybatis.mapper.SysUserRoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GPortraitApplicationTests {
	@Autowired
	private MeSysUserInfoMapper meSysUserInfoMapper;

	@Autowired
	private SysUserMapper sysUserMapper;
	@Test
	public void contextLoads() {
		SysUser sysUser = sysUserMapper.selectByUsername("admin");
		System.out.println(sysUser.getName()+","+sysUser.getUsername());
	}


}
