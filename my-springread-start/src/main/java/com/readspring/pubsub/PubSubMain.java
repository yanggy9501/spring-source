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
 *
 * List<String> stringList = new ArrayList<>();
 * List<Integer> integerList = new ArrayList<>();
 * 在运行时，stringList和integerList的类型都是List，而无法区分它们具体存储的元素类型(假设不添加任何元素，更不知道具体类型了)。
 *
 * 在例如：
 * ApiResponse<List<String>> response = restTemplate.exchange(
 *     url,
 *     HttpMethod.GET,
 *     new HttpEntity<>(headers),
 *     ApiResponse.class
 * ).getBody();
 * 在这个例子中，ApiResponse.class无法提供T的类型信息。
 *
 * 为了解决泛型擦除问题，我们可以借助 ParameterizedTypeReference和 ResolvableType 类来保留泛型信息。
 * ParameterizedTypeReference是Spring框架提供的一个工具类，它允许我们在运行时保留泛型类型信息。以下是使用ParameterizedTypeReference的代码示例：
 * ApiResponse<List<String>> response = restTemplate.exchange(
 *     url,
 *     HttpMethod.GET,
 *     new HttpEntity<>(headers),
 *     new ParameterizedTypeReference<ApiResponse<List<String>>>() {}
 * ).getBody();
 *
 * esolvableType允许我们在运行时动态构造包含泛型信息的类型。在以下代码中，我们使用ResolvableType动态构建ApiResponse<T>的类型，并使用ParameterizedTypeReference来获取泛型信息：
 * ApiResponse<T> apiResponse = (ApiResponse<T>) restTemplate.exchange(
 *     url,
 *     method,
 *     new HttpEntity<>(body, headers),
 *     ParameterizedTypeReference.forType(
 *         ResolvableType.forClassWithGenerics(ApiResponse.class, clazz).getType()
 *     )
 * ).getBody();
 *
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
