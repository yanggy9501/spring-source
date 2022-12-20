package com.readspring.proxy.origin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yanggy
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        TestJdkInterface target = new TestJdkService();

        TestJdkInterface proxy = (TestJdkInterface) Proxy.newProxyInstance(JdkProxyTest.class.getClassLoader(),
				new Class<?>[]{TestJdkInterface.class},
				new InvocationHandler() {
            /**
             * @param proxy 被 jdk 代理的代理对象
             * @param method 原始对象中的方法
             * @param args 方法的参数
             *
             * @return Object
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before...");
                Object result = method.invoke(target, args);
                System.out.println("after...");
                return result;
            }
        });

        proxy.test();
    }
}
