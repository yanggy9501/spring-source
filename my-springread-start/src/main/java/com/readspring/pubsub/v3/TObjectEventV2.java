package com.readspring.pubsub.v3;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

public class TObjectEventV2<T> extends ApplicationEvent implements ResolvableTypeProvider {
	private static final long serialVersionUID = 0L;
	
	private T data;


	public TObjectEventV2(T data) {
		super(data);
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
