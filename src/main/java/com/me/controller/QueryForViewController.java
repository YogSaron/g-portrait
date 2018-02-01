package com.me.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.me.common.utils.R;
import com.me.common.wrapBeans.UserBean;
import com.me.service.QueryForViewService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Logan Zhou on 2018-01-24.
 */
@Controller
@EnableAutoConfiguration
public class QueryForViewController {

    @Autowired
    private QueryForViewService queryForViewService;

    @RequestMapping("/")
    String forwardToIndex(){
        return "forward:/index.html";
    }
//    首页
    @RequestMapping("/index")
    String toIndex() {

        return "index";
    }

    /**
     * 数据保存
     * @param userBean
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/post/userInfoSave")
    public @ResponseBody
    R queryForPortraitController(UserBean userBean, RedirectAttributes redirectAttributes) {
        Integer id = null;
        try {
            id = queryForViewService.doPortraitInfoSave(userBean);
            if (id==null){
                return R.error();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("保存用户失败，您的输入可能有误");
        }

        return R.ok().put("id",id);
    }


    /**
     * 跳转到结果界面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/resultView")
    public ModelAndView userInfoSave(Integer id,Model model){
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> map = new HashMap();
        try {
            map = queryForViewService.getUserInfoById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("queryView");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }
}
