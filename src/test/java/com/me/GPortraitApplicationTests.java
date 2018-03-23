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

import java.lang.reflect.Method;

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

	@Test
	public void rotate(){
		System.out.println(reversal("abcdefg",9));
	}

	private String reversal(String str,int offsetNum){
		offsetNum = offsetNum%str.length();
		String lateNum = str.substring(str.length()-offsetNum);
		String frontNum = str.substring(0,str.length()-offsetNum);
		return lateNum+frontNum;
	}


	public void te(){
		SysUser sysUser = new SysUser();
		try {
			Method method = sysUser.getClass().getMethod("getName",SysUser.class);
			method.invoke(sysUser,new Object[]{});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
