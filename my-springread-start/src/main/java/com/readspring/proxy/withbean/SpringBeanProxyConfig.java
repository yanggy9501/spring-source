package com.readspring.proxy.withbean;

import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;

/**
 * @author yanggy
 */
//@Configuration
//@ComponentScan("com.readspring.proxy.withbean")
public class SpringBeanProxyConfig {

    // 将代理对象注册成bean（很少用）
//    @Bean
//    public ProxyFactoryBean proxyFactoryBean() {
//        // Service 不要加 @Component 注解
//		WithRequireProxyService target = new WithRequireProxyService();
//        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
//        proxyFactoryBean.setTarget(target);
//        proxyFactoryBean.addAdvice(new MethodBeforeAdvice() {
//            /**
//             *
//             * @param method the method being invoked
//             * @param args the arguments to the method
//             * @param target the target of the method invocation.(原始对象)
//             * @throws Throwable
//             */
//            @Override
//            public void before(Method method, Object[] args, Object target) throws Throwable {
//                System.out.println("before...");
//            }
//        });
//        return proxyFactoryBean;
//    }

    // 将代理对象注册成bean（很少用） 比 ProxyFactoryBean 强，根据 beanName，利用BeanPostProcessor处理的
//    @Bean
//    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
//        BeanNameAutoProxyCreator proxyCreator = new BeanNameAutoProxyCreator();
//        proxyCreator.setBeanNames("requireProxyService");
//        proxyCreator.setInterceptorNames("myAroundAdvice");
//        proxyCreator.setProxyTargetClass(true);
//
//        return proxyCreator;
//    }
//
    // Advisor = pointcut + advice 和 DefaultAdvisorAutoProxyCreator 一起用
    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        // 代理方法
        pointcut.addMethodName("func1");

        DefaultPointcutAdvisor dpa = new DefaultPointcutAdvisor();
        dpa.setPointcut(pointcut);
        dpa.setAdvice(new MyAroundAdvice());

        return dpa;
    }

	@Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }
}
