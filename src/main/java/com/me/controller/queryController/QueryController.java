package com.me.controller.queryController;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Logan Zhou on 2018-01-24.
 */
@Controller
@EnableAutoConfiguration
public class QueryController {

    @RequestMapping("/")
    String index(){

        return "index";
    }

    @PostMapping("queryForPortrait")
    String queryForPortraitController(){
        return "queryView";
    }
}
