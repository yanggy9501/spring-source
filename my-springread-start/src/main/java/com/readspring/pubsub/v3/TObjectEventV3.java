package com.readspring.pubsub.v3;

import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

public class TObjectEventV3<T> implements ResolvableTypeProvider {
	private static final long serialVersionUID = 0L;

	private T data;


	public TObjectEventV3(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	// 可解析类型
	@Override
	public ResolvableType getResolvableType() {
		return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(getData()));
	}
}
