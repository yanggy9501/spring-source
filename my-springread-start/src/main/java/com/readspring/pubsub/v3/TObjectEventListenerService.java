package com.readspring.pubsub.v3;

import com.readspring.entity.User;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TObjectEventListenerService {

	@EventListener
	public void handleEvent(TObjectEvent<User> personEvent) {
		System.out.println("EventListenerService:TObjectEvent<User>");
		System.out.println(personEvent);
	}

	@EventListener
	public void handleEventV2(TObjectEventV2<User> personEvent) {
		System.out.println("EventListenerService:TObjectEventV2<User>");
		System.out.println(personEvent);
	}

	@EventListener
	public void handleEventV3(TObjectEventV3<User> personEvent) {
		System.out.println("EventListenerService:TObjectEventV3<User>");
		System.out.println(personEvent);
	}
}
