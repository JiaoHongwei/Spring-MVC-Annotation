package com.hw.controller;

import com.hw.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description TODO
 * @Author hw
 * @Date 2018/12/18 18:27
 * @Version 1.0
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        String hello = helloService.sayHello("tomcat...");
        return hello;
    }

    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}
