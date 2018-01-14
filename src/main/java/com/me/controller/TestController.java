package com.me.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/1/10.
 */
@RestController
@EnableAutoConfiguration
public class TestController {

    @RequestMapping("/hello")
    String index(){

        return "Hello World";
    }
}
