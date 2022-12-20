package com.readspring.proxy.origin;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author yanggy
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        TestCglibService target = new TestCglibService();

        Enhancer enhancer = new Enhancer();
        // cglib 使用继承的方式，需要设置父类，设置增强方法
        enhancer.setSuperclass(TestCglibService.class);
        enhancer.setCallbacks(new Callback[]{new MethodInterceptor() {
            /**
             * 增强逻辑
             * 可以添加多个拦截，通过方法名对同一对象不同方法设置不同增强逻辑
             * cglib 对此还提供了其他api
             *
             * @param obj 被 cglib 代理对象 (enhancer.create() 出来的那个对象)
             * @param method 原始对象的被代理方法
             * @param args 方法参数
             * @param methodProxy cglib 代理子类中对method覆写方法
             * @return Object
             * @throws Throwable
             */
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("before");
                //Object result = methodProxy.invoke(target, args);
                //Object result = methodProxy.invokeSuper(obj, args);
                Object result = method.invoke(target, args);

                System.out.println("after....");
                return result;
            }
        }});

        // 根据方法设置不同的拦截器，对应 Callback[] 的下标
//        enhancer.setCallbackFilter(new CallbackFilter() {
//            @Override
//            public int accept(Method method) {
//                return 0;
//            }
//        });

        TestCglibService proxy = (TestCglibService) enhancer.create();
        proxy.test();
    }
}
