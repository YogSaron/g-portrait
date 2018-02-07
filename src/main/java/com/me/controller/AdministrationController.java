package com.me.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Logan Zhou on 2018-02-01.
 */
@Controller
@RequestMapping("/admin")
public class AdministrationController {

    @RequestMapping("/login")
    public String toAdminLogin (){
        return "admin/login";
    }
}
