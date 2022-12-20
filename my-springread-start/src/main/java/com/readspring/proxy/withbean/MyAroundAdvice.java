package com.readspring.proxy.withbean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author yanggy
 */
public class MyAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("around before...");
        Object result = invocation.proceed();
        System.out.println("around after...");
        return result;
    }
}
