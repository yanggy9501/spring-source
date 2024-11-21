package com.readspring.pubsub.v3;

public class TObjectEvent<T> {
	private T data;

	public TObjectEvent() {

	}

	public TObjectEvent(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
