package com.hw;

import com.hw.config.AppConfig;
import com.hw.config.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Description web 容器启动的时候 调用方法来初始化容器以及前端控制器
 * @Author hw
 * @Date 2018/12/18 18:17
 * @Version 1.0
 */
public class WebApplicationContext extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 获取根容器的配置类
     *
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /**
     * 获取web容器的配置文件
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    /**
     * 获取servlet 映射信息
     * / : 拦截所有资源  但不包括  *.jsp
     * /* : 拦截所有资源  包括  *.jsp
     * <p>
     * jsp 页面是tomcat的jsp引擎解析的
     *
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
