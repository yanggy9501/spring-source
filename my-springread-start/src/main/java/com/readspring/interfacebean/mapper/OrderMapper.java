package com.readspring.interfacebean.mapper;

import com.readspring.entity.User;
import com.readspring.interfacebean.mapper.proxy.MapperSpring;

@MapperSpring
public interface OrderMapper {
	User get(User user);
}
