package com.readspring.pubsub.v1;

import com.readspring.entity.User;

public class UserObjectEvent {
	private User user;

	public UserObjectEvent() {

	}

	public UserObjectEvent(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
