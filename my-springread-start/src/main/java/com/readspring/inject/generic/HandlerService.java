package com.readspring.inject.generic;

import com.readspring.entity.Order;
import com.readspring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandlerService {
	@Autowired
	private GHandler<Order> orderGHandler;

	@Autowired
	private GHandler<User> userGHandler;

	public void test() {
		System.out.println(orderGHandler);
		System.out.println(userGHandler);
	}
}
