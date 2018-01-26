package com.me;

import com.me.mybatis.entity.MeSysUserInfo;
import com.me.mybatis.mapper.MeSysUserInfoMapper;
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

	@Test
	public void contextLoads() {
		MeSysUserInfo meSysUserInfo = new MeSysUserInfo();
		meSysUserInfo.setSex(1);
		meSysUserInfo.setUsername("赵四");
		meSysUserInfoMapper.insertSelective(meSysUserInfo);
	}

}
