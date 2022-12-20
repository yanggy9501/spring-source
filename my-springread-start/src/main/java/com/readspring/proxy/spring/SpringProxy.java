package com.readspring.proxy.spring;

import com.readspring.proxy.RequireProxyService;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * @author yanggy
 */
public class SpringProxy {
    public static void main(String[] args) {
        RequireProxyService target = new RequireProxyService();

        // 使用 spring 的代理（底层时jdk或cglib代理）
        ProxyFactory proxyFactory = new ProxyFactory();
        // 设置被代理的对象
        proxyFactory.setTarget(target);
        // proxyFactory.setInterfaces(); 接口用这个

        // 添加通知（即增强逻辑）：前置通知
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            /**
             *
             * @param method the method being invoked
             * @param args the arguments to the method
             * @param target the target of the method invocation.(原始对象)
             * @throws Throwable
             */
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("before...");
            }
        });

        // 后置通知
        proxyFactory.addAdvice(new AfterReturningAdvice() {
            @Override
            public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
                System.out.println("after...");
            }
        });

        // 异常通知：该接口没有提供方法，因为异常在运行过程中是不可预知的不好定义异常，但是对方法及其参数位置是有要求的
        proxyFactory.addAdvice(new ThrowsAdvice() {
            public void afterThrowing(Method method, Object[] orgs, Object target, Exception e) {

            }
        });

        // 坏绕通知
        proxyFactory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                System.out.println("around before...");
                Object result = invocation.proceed();
                System.out.println("around after...");
                return result;
            }
        });

        // 控制方法是否需要被增强：advice 只是一段代理逻辑，不能表示那个方法需要被正确。 一个真正的 Advisor = Pointcut + Advice
//        proxyFactory.addAdvisor(new PointcutAdvisor() {
//            /**
//             * 切点：匹配逻辑（哪些方法需要被增强）
//             * @return Pointcut
//             */
//            @Override
//            public Pointcut getPointcut() {
//                return null;
//            }
//
//            /**
//             * Pointcut 对应的 Advice
//             *
//             * @return Advice 增强
//             */
//            @Override
//            public Advice getAdvice() {
//                return null;
//            }
//
//            @Override
//            public boolean isPerInstance() {
//                return false;
//            }
//        });

        // 获取代理对象
        RequireProxyService proxy = (RequireProxyService) proxyFactory.getProxy();
        // 如果有多个相同位置的增强，增强的执行与添加顺序有关（底层链路执行 org.springframework.aop.framework.ReflectiveMethodInvocation.interceptorsAndDynamicMethodMatchers）
        // 代理对象是怎么执行方法的，jdk的看 invoke 方法 org.springframework.aop.framework.JdkDynamicAopProxy#invoke
        proxy.func1();
    }
}
