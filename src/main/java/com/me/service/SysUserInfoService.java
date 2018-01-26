package com.me.service;

import com.me.common.wrapBeans.UserBean;
import org.springframework.stereotype.Service;

/**
 * Created by Logan Zhou on 2018-01-26.
 */
public interface SysUserInfoService {

    public void doPortraitInfoSave(UserBean userBean);
}
