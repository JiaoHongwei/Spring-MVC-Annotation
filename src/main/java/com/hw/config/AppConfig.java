package com.hw.config;

import com.hw.controller.MyFirstInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Description spring mvc 只扫描 controller   子容器
 * @Author hw
 * @Date 2018/12/18 18:22
 * @Version 1.0
 */

@EnableWebMvc
@ComponentScan(value = "com.hw",
        useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})})
public class AppConfig implements WebMvcConfigurer {


    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.jsp();
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyFirstInterceptor()).addPathPatterns("/**");
    }
}
