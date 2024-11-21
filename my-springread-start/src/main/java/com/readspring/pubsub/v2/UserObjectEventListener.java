package com.readspring.pubsub.v2;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserObjectEventListener implements ApplicationListener<UserObjectApplicationEvent> {

	@Override
	public void onApplicationEvent(UserObjectApplicationEvent event) {
		System.out.println("UserObjectEventListener:UserObjectApplicationEvent");
		System.out.println(event);
	}
}
