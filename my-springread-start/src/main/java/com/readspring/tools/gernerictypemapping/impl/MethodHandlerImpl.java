package com.readspring.tools.gernerictypemapping.impl;

import com.readspring.tools.gernerictypemapping.MethodHandler;
import com.readspring.tools.gernerictypemapping.obj.Msg;
import com.readspring.tools.gernerictypemapping.obj.Tag;
import org.springframework.stereotype.Component;

@Component
public class MethodHandlerImpl implements MethodHandler {

	public void handleMsg(Msg input) {
		System.out.println(input);
	}

	public void handleTag(Tag input) {
		System.out.println(input);
	}
}
