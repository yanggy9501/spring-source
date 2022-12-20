package com.readspring.proxy;

import org.springframework.stereotype.Component;

/**
 * @author yanggy
 */
@Component
public class RequireProxyService implements IRequireProxyService {

    public String func1() {
        System.out.println("func1...");
        return "func1";
    }

    public String func2() {
        System.out.println("func2...");
        return "func2";
    }
}
