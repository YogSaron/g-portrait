package com.me.service.serviceImpl;

import com.me.mybatis.entity.SysUser;
import com.me.mybatis.mapper.SysUserMapper;
import com.me.service.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Logan Zhou on 2018-02-01.
 */
@Service("administrationService")
public class AdministrationServiceImpl implements AdministrationService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getSysUserByUsername(String username) {
        SysUser sysUser = sysUserMapper.selectByUsername(username);
        return sysUser;
    }
}
