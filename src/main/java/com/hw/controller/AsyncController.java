package com.hw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

/**
 * @Description TODO
 * @Author hw
 * @Date 2018/12/19 11:40
 * @Version 1.0
 */
@Controller
public class AsyncController {

    @RequestMapping("async01")
    @ResponseBody
    public Callable<String> async01() {

        System.out.println("主线程开始..." + Thread.currentThread() + "===》" + System.currentTimeMillis());
        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                System.out.println("子线程开始..." + Thread.currentThread() + "===》" + System.currentTimeMillis());
                Thread.sleep(3000);
                System.out.println("子线程结束..." + Thread.currentThread() + "===》" + System.currentTimeMillis());
                return "Callable<String> async01()";
            }
        };
        System.out.println("主线程结束..." + Thread.currentThread() + "===》" + System.currentTimeMillis());
        return callable;
    }
}
