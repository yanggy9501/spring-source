package com.readspring.tools.gernerictypemapping.obj;

public class Msg {
	private String msg;
	private Integer code;

	public Msg(String msg, Integer code) {
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Msg{" +
				"msg='" + msg + '\'' +
				", code=" + code +
				'}';
	}
}
