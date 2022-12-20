package com.readspring.proxy.origin;

/**
 * @author yanggy
 */
public class TestCglibService {
    public String test() {
        System.out.println("doing...");
        return "hello cglib";
    }

    public String testTwo() {
        System.out.println("doing two...");
        return "hello cglib";
    }

}
