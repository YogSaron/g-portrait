package com.me.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Logan Zhou on 2018-02-01.
 */
@Controller
@EnableAutoConfiguration
@RequestMapping("/admin")
public class AdministrationController {

    @RequestMapping("login")
    public String toAdminLogin (HttpServletRequest request,Map<String,Object> map){

        return "admin/login";
    }

    @RequestMapping("access/index")
    public String toAdminIndex(){
        return "admin/access/index";
    }
}
