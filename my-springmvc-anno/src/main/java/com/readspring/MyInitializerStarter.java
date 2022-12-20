package com.readspring;

import com.readspring.config.AppConfig;
import com.readspring.config.WebAppConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author yanggy
 */
public class MyInitializerStarter extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * IOC: 父容器的启动配置类
     *
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{AppConfig.class};
    }

    /**
     * IOC: 子容器的启动配置类(web 容器)
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebAppConfig.class};
    }

    /**
     * DispatcherServlet 的拦截路径
     *
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
