package com.readspring.interfacebean.rpcdemo.annotation;

import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RpcMapping {

    String uri() default "";

    RequestMethod method() default RequestMethod.GET;
}
