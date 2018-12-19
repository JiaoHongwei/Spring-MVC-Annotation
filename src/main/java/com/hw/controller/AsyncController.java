package com.hw.controller;

import com.hw.service.DeferredResultQueue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
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


    /**
     * 创建订单加入 订单处理队列
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/createOrder")
    public DeferredResult<Object> createOrder() {
        // 超时间  10秒钟
        DeferredResult<Object> deferredResult = new DeferredResult<Object>(10 * 1000L, "create order error");
        DeferredResultQueue.save(deferredResult);
        return deferredResult;
    }

    /**
     * 另外一个线程 从队列中读取 订单任务 开始创建 ，并返回结果
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/create")
    public String create() {
        String uuid = UUID.randomUUID().toString();
        DeferredResult deferredResult = DeferredResultQueue.get();
        deferredResult.setResult(uuid);
        return "success===>>>> " + uuid;
    }
}
