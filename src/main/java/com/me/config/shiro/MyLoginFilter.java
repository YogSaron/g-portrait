package com.me.config.shiro;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by Logan Zhou on 2018-03-06.
 */
public class MyLoginFilter extends FormAuthenticationFilter{
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        String successUrl = "/admin/access/index.html";
        WebUtils.issueRedirect(request,response,successUrl);
        return false;
    }
}
