package com.me.controller.queryController;

import com.me.common.wrapBeans.UserBean;
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

    @RequestMapping("/index")
    String index() {

        return "index";
    }

    @PostMapping("/index/queryForPortrait")
    String queryForPortraitController(UserBean userBean,Model model) {

        return "queryView";
    }


}
