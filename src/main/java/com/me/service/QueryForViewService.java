package com.me.service;

import com.me.common.wrapBeans.UserBean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Logan Zhou on 2018-01-26.
 */
public interface QueryForViewService {

    public Integer doPortraitInfoSave(UserBean userBean);

    public Map<String,Object> getUserInfoById(Integer id);
}
