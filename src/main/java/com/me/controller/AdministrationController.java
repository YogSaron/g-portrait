package com.me.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Logan Zhou on 2018-02-01.
 */
@Controller
public class AdministrationController {

    @RequestMapping(value = "/admin/login")
    public String toAdminLogin(HttpServletRequest request, Map<String, Object> map) {
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> " + exception;
                System.out.println("else -- >" + exception);
            }
        }
        return "admin/login";
    }

    @RequestMapping(value="/admin/")
    public String toAdminIndex() {
        return "/admin/access/index";
    }

/*    @RequestMapping("/logout")
    public String toLogout(){

        return "redirect:/admin/login";
    }*/
}