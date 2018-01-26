package com.me.controller.queryController;

import com.me.common.wrapBeans.UserBean;
import com.me.mybatis.entity.MeSysPortraitInfo;
import com.me.service.SysUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Logan Zhou on 2018-01-24.
 */
@Controller
@EnableAutoConfiguration
public class QueryController {

    @Autowired
    private SysUserInfoService sysUserInfoService;

    @RequestMapping("/index")
    String index() {

        return "index";
    }

    @PostMapping("/queryForPortrait")
    String queryForPortraitController(UserBean userBean,Model model) {
        sysUserInfoService.doPortraitInfoSave(userBean);
        return "queryView";
    }


}
