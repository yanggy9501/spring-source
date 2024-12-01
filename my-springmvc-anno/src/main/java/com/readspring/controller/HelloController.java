package com.readspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yanggy
 */
@Controller //在 HandlerMapping 子类中有个RequestMappingHandlerMapping ，
// 其作用是在容器启动后将系统中所有控制器方法的请求条件和控制器方法的对应关系注册到 RequestMappingHandlerMapping
// 子类 MappingRegistry 的容器中。当有请求进来时，RequestMappingHandlerMapping 会根据请求条件和容器中存储的系统接口信息比对，
// 再执行对应的控制器方法，从而帮助 DispatcherServlet 分发请求。
@RequestMapping("/")
public class HelloController {

    @RequestMapping("/")
    @ResponseBody
    public String get1() {
        System.out.println("hello....");
        return "hello ok!";
    }

    @RequestMapping("/t2")
    public String get2() {
        System.out.println("hello....");
        return "hello ok!";
    }
}
