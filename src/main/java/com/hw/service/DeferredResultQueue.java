package com.hw.service;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Description TODO
 * @Author hw
 * @Date 2018/12/19 15:40
 * @Version 1.0
 */
public class DeferredResultQueue {

    private static Queue<DeferredResult<Object>> queue = new ConcurrentLinkedQueue<DeferredResult<Object>>();

    public static void save(DeferredResult<Object> object) {
        queue.add(object);
    }

    public static DeferredResult<Object> get() {
        return queue.poll();
    }

}
