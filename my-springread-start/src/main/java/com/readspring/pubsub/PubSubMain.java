package com.readspring.pubsub;

import com.readspring.entity.User;
import com.readspring.pubsub.v1.UserObjectEvent;
import com.readspring.pubsub.v2.UserObjectApplicationEvent;
import com.readspring.pubsub.v3.TObjectEvent;
import com.readspring.pubsub.v3.TObjectEventV2;
import com.readspring.pubsub.v3.TObjectEventV3;
import org.springframework.context.annotation.*;

/**
 * spring 事件发布器解决泛型擦除问题，事件发布器发布带泛型的事件 event， 监听器如何监听到带有泛型的事件 event。泛型都是object，?
 * 即如何知道泛型的具体类型是哪个，从而找到该具体类型的监听器？
 * 核心逻辑就在 ResolvableTypeProvider 接口里面，重写了 getResolvableType 方法，
 * 在运行期动态的获取泛型对应的真正的对象类型，从而解决了编译阶段泛型擦除的问题。
 */
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
