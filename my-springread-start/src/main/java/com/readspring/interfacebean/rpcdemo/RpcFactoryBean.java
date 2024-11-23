package com.readspring.interfacebean.rpcdemo;

import com.readspring.interfacebean.rpcdemo.proxy.RpcInvocation;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Proxy;

public class RpcFactoryBean<T> implements FactoryBean<T>, BeanClassLoaderAware {

    private ClassLoader classLoader;

    private Class<T> type;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }


    @SuppressWarnings("all")
    @Override
    public T getObject() throws Exception {
        return (T) Proxy.newProxyInstance(
            classLoader,
            new Class<?>[]{type},
            new RpcInvocation(restTemplate, type)
        );
    }

    @Override
    public Class<?> getObjectType() {
        return type;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public Class<T> getType() {
        return type;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
