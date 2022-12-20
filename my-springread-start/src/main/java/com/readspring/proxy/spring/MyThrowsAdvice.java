package com.readspring.proxy.spring;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author yanggy
 */
//@Component
public class MyThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(Method method, Object[] orgs, Object target, Exception e) {
        System.out.println("发送异常：" + e);
    }
}
