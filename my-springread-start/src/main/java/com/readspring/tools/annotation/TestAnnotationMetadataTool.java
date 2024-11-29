package com.readspring.tools.annotation;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

public class TestAnnotationMetadataTool {
	public static void main(String[] args) {
		AnnotationMetadata metadata = AnnotationMetadata.introspect(AnnoObj.class);
		System.out.println(metadata.hasAnnotation(Component.class.getName()));
	}
}
