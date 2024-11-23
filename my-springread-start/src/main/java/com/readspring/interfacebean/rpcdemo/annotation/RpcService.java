package com.readspring.interfacebean.rpcdemo.annotation;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RpcService {
    String protocol() default "http";

    String host() default "127.0.0.1";

    int port() default 8080;
}
