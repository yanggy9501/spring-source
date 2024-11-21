package com.readspring.pubsub.v1;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventListenerService {

	@EventListener
	public void handleEvent(UserObjectEvent userObjectEvent) {
		System.out.println("EventListenerService:userObjectEvent");
		System.out.println(userObjectEvent);
	}
}
