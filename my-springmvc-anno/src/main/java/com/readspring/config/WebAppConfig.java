package com.readspring.config;

import com.readspring.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * web 配置
 * 注解配置视图解析
 */
@Configuration
@ComponentScan(basePackages = "com.readspring", includeFilters = {
    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {RestController.class, Controller.class})
})
@EnableWebMvc /*xxx: <mvc:annotation-driven/> 里面有很多的 bean 配置*/
/*xxx: 实现 WebMvcConfigurer 接口 因为@EnableWebMvc导入的类会找到实现了该接口的对象，调用相关方法获取配置 */
public class WebAppConfig implements WebMvcConfigurer {

    /**
     * 视图解析器
     *
     * @return InternalResourceViewResolver 视图解析器
     */
    @Bean
    public InternalResourceViewResolver jspInternalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".html");
        return viewResolver;
    }

    /**
     * 视图解析器配置
     *
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(jspInternalResourceViewResolver());
    }

    /**
     * 静态资源配置
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // tomcat默认处理静态资源的servlet名称为default,不指定也可以DefaultServletHttpRequestHandler.setServletContext会自动获取
        configurer.enable("default");
//        configurer.enable();
    }

    /**
     * 拦截器
     *
     * @return
     */
    @Bean
    public HandlerInterceptor handlerInterceptor() {
        return new MyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handlerInterceptor());
    }
}
