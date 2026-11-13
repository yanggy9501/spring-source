package com.readspring.tools.gernerictypemapping.impl;

import com.readspring.tools.gernerictypemapping.Handler;
import com.readspring.tools.gernerictypemapping.obj.Msg;
import org.springframework.stereotype.Component;

@Component
public class MsgHandler implements Handler<Msg> {

	@Override
	public void handle(Msg input) {
		System.out.println(input);
	}
}
