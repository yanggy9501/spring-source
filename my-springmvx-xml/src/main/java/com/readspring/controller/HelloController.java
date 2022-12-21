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

	@ResponseBody
	@RequestMapping("/t1")
    public String get1() {
        System.out.println("hello....");
        return "hello ok!";
    }
}
