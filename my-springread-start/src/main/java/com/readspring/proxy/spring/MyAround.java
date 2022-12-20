package com.readspring.proxy.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 * @author yanggy
 */
//@Component
public class MyAround implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("around before...");
        Object result = invocation.proceed();
        System.out.println("around after...");
        return result;
    }
}
