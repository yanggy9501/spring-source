package com.readspring.entity;

/**
 * @author yanggy
 */
public class User {
    private String name;

    private String age;

    private String sex;

    @Override
    public String toString() {
        return "User{" +
            "name='" + name + '\'' +
            ", age='" + age + '\'' +
            ", sex='" + sex + '\'' +
            '}';
    }
}
