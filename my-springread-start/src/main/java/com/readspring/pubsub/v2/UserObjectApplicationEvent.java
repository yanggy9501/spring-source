package com.readspring.pubsub.v2;

import com.readspring.entity.User;
import org.springframework.context.ApplicationEvent;

public class UserObjectApplicationEvent extends ApplicationEvent {
	private static final long serialVersionUID = 0L;

	private User user;

	public UserObjectApplicationEvent(User user) {
		super(user);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
