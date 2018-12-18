package com.hw.service;

import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author hw
 * @Date 2018/12/18 18:28
 * @Version 1.0
 */
@Service
public class HelloService {


    public String sayHello(String name) {
        return "hello :" + name;
    }
}
