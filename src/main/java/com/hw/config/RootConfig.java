package com.hw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Description 不扫描 controller  父容器
 * @Author hw
 * @Date 2018/12/18 18:21
 * @Version 1.0
 */
@ComponentScan(value = "com.hw", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})})
public class RootConfig {
}
