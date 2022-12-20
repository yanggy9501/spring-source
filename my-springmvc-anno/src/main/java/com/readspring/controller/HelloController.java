package com.readspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yanggy
 */
@Controller
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
