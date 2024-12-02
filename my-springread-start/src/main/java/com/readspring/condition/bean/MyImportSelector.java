package com.readspring.condition.bean;

import com.readspring.condition.MyCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

@Conditional(MyCondition.class)
@Component
// 一般是自动配置，批量注入
public class MyImportSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"com.readspring.condition.bean.MyImportSelector.MyImportBean"};
	}

	public static class MyImportBean {

	}
}
