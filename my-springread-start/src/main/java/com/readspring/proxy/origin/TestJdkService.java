package com.readspring.proxy.origin;

/**
 * @author yanggy
 */
public class TestJdkService implements  TestJdkInterface {
    @Override
    public String test() {
        System.out.println("jdk doing...");
        return "jdk proxy";
    }
}
