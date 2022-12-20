package com.readspring.transaction;

import com.readspring.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yanggy
 */
public class MainTx {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyTransactionService service = context.getBean("myTransactionService", MyTransactionService.class);
        service.testSql();
    }
}
