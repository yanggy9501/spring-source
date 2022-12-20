package com.readspring.proxy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 解析后得到对应的Pointcut对象、Advice对象，生成Advisor对象，扔进ProxyFactory中
 * @author yanggy
 */
@Component
@Aspect // @EnableAspectJAutoProxy
public class MyAspect {

    @Before("execution(public String com.readspring.proxy.RequireProxyService.func1())")
    public void beforeFunc1(JoinPoint joinPoint) {
        System.out.println("@Before...");
    }
}
