package com.readspring.condition;

import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

// org.springframework.context.annotation.ConditionEvaluator#shouldSkip
// 在 beanDefinition 扫描的时候执行
public class MyCondition implements Condition {
	public MyCondition() {
		System.out.println("-------------");
	}

	/**
	 * @param context the condition context
	 * @param metadata metadata of the {@link org.springframework.core.type.AnnotationMetadata class}
	 * or {@link org.springframework.core.type.MethodMetadata method} being checked
	 * @return
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		return context.getEnvironment().getProperty("my.condition.enabled", Boolean.class, false);
	}
}

