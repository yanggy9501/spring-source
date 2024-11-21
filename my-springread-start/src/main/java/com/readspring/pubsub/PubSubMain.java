package com.readspring.pubsub;

import com.readspring.entity.User;
import com.readspring.pubsub.v1.UserObjectEvent;
import com.readspring.pubsub.v2.UserObjectApplicationEvent;
import com.readspring.pubsub.v3.TObjectEvent;
import com.readspring.pubsub.v3.TObjectEventV2;
import com.readspring.pubsub.v3.TObjectEventV3;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"com.readspring.pubsub"})
@EnableAspectJAutoProxy(exposeProxy = true)
public class PubSubMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PubSubMain.class);

		System.out.println("----------------");

		context.publishEvent(new UserObjectEvent(new User("zs", "19", "男")));

		context.publishEvent(new UserObjectApplicationEvent(new User("zs", "19", "男")));

		// 这个有类型擦除，没有效果
		context.publishEvent(new TObjectEvent<>(new User("zs", "19", "男")));

		context.publishEvent(new TObjectEventV2<>(new User("zs", "19", "男")));

		context.publishEvent(new TObjectEventV3<>(new User("zs", "19", "男")));


	}
}
