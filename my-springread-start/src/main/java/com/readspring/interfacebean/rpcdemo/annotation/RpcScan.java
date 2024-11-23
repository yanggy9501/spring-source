package com.readspring.interfacebean.rpcdemo.annotation;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RpcScan {
    String[] value();

    String[] basePackages() default {};
}
