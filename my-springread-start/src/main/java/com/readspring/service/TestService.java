package com.readspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yanggy
 */
@Service
public class TestService {
    @Autowired
    private OrderService orderService;
}
