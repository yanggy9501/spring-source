package com.readspring.importor;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Import(MyImportBean.class) // 配置类扫描时处理 @see org.springframework.context.annotation.ConfigurationClassParser.processImports
//@ImportResource(locations = "classpath:xxx.xml")
public class ImportConfig {
}
