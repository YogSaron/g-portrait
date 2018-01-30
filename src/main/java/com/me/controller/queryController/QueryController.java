package com.me.controller.queryController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.me.common.utils.R;
import com.me.common.wrapBeans.UserBean;
import com.me.mybatis.entity.MeSysFiveElements;
import com.me.mybatis.entity.MeSysUserInfo;
import com.me.service.SysUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;

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

    @PostMapping("/post/userInfoSave")
    public @ResponseBody
    R queryForPortraitController(UserBean userBean, RedirectAttributes redirectAttributes) {
        Integer id = null;
        try {
            id = sysUserInfoService.doPortraitInfoSave(userBean);
            if (id==null){
                return R.error();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("保存用户失败，您的输入可能有误");
        }

        return R.ok().put("id",id);
    }


    @RequestMapping("/feedback/view")
    public ModelAndView userInfoSave(@ModelAttribute("userInfo") String userInfo,@ModelAttribute("fE") String fE,Model model){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            MeSysUserInfo  meSysUserInfo= objectMapper.readValue(userInfo,MeSysUserInfo.class);
            MeSysFiveElements meSysFiveElements = objectMapper.readValue(fE,MeSysFiveElements.class);
            model.addAttribute("userInfo",meSysUserInfo);
            model.addAttribute("fE",meSysFiveElements);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("queryView");
        return modelAndView;
    }
}
