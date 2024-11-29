package com.readspring.importor;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelectorBean implements ImportSelector {

	// 将返回的需要被导入的 bean 的类的全限定名称
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[0];
	}
}
