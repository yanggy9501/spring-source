package com.readspring.proxy.spring;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * Advisor = pointcut(匹配) + advice（增强）
 *
 * @author yanggy
 */
public class MyAdvisor implements PointcutAdvisor {
    /**
     * 增强
     *
     * @return
     */
    @Override
    public Advice getAdvice() {
        return new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                System.out.println("before...");
                Object result = invocation.proceed();
                System.out.println("after...");
                return result;
            }
        };
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }

    /**
     * Pointcut: 类和方法的匹配器
     * 通过Pointcut可以指定要需要被代理的逻辑
     * 如下：代理对象，只有在执行testAbc这个方法时才会被增强
     *
     * @return
     */
    @Override
    public Pointcut getPointcut() {
        return new StaticMethodMatcherPointcut() {
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                return method.getName().equals("testAbc");
            }
        };
    }
}
