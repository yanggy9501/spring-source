package com.readspring.interfacebean.mapper;

import com.readspring.entity.User;
import com.readspring.interfacebean.mapper.proxy.Mapper;

@Mapper
public interface UserMapper {
	User get(User user);
}
