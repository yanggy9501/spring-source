package com.readspring.tools.gernerictypemapping.impl;

import com.readspring.tools.gernerictypemapping.Handler;
import com.readspring.tools.gernerictypemapping.obj.Msg;
import com.readspring.tools.gernerictypemapping.obj.Tag;
import org.springframework.stereotype.Component;

@Component
public class TagHandler implements Handler<Tag> {

	@Override
	public void handle(Tag input) {
		System.out.println(input);
	}
}
