package com.readspring.inject.generic;

import com.readspring.entity.Order;
import com.readspring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandlerService {
	@Autowired
	private GHandler<Order> oGHandler;

	@Autowired
	private GHandler<User> uGHandler;

	public void test() {
		System.out.println(oGHandler);
		System.out.println(uGHandler);
	}
}
