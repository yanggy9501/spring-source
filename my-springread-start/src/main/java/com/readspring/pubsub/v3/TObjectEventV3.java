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

	// 可解析类型，因为泛型没有参数化，所以是获取不到，需要通过运行期泛型实例对象的 ResolvableType（反射能获取泛型信息，但是泛型必须参数化）
	@Override
	public ResolvableType getResolvableType() {
		return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(this.data));
	}
}
