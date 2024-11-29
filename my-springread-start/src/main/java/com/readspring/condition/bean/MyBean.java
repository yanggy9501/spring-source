package com.readspring.condition.bean;

import com.readspring.condition.MyCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Conditional(MyCondition.class)
@Component
public class MyBean {
}
