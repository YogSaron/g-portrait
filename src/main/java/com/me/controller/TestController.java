package com.me.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/1/10.
 */
@RestController
@SpringBootApplication
public class TestController {

    @RequestMapping("/")
    String index(){

        return "Hello World";
    }
}
