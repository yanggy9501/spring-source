package com.readspring.interfacebean.factorybean.v1;

import com.readspring.interfacebean.mapper.proxy.MapperProxyFactory;
import org.springframework.beans.factory.FactoryBean;

public class MapperFactoryBeanV1<T> implements FactoryBean<T> {
	private MapperProxyFactory<T> mapperProxyFactory;

	private Class<T> type;

	public MapperFactoryBeanV1() {
	}

	public MapperFactoryBeanV1(MapperProxyFactory<T> mapperProxyFactory, Class<T> type) {
		this.mapperProxyFactory = mapperProxyFactory;
		this.type = type;
	}

	@Override
	public T getObject() throws Exception {
		return mapperProxyFactory.newProxyInstance(new Class<?>[]{type});
	}

	@Override
	public Class<?> getObjectType() {
		return type;
	}

	public MapperProxyFactory<T> getMapperProxyFactory() {
		return mapperProxyFactory;
	}

	public void setMapperProxyFactory(MapperProxyFactory<T> mapperProxyFactory) {
		this.mapperProxyFactory = mapperProxyFactory;
	}

	public Class<T> getType() {
		return type;
	}

	public void setType(Class<T> type) {
		this.type = type;
	}
}
