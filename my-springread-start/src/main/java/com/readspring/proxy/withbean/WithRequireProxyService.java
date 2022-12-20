package com.readspring.proxy.withbean;

//@Component
public class WithRequireProxyService implements IWithRequireProxyService {

    public String func1() {
        System.out.println("func1...");
        return "func1";
    }

    public String func2() {
        System.out.println("func2...");
        return "func2";
    }
}
