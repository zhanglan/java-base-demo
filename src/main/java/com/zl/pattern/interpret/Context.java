package com.zl.pattern.interpret;

import lombok.Data;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
@Data
public class Context {

	private String input;

	private String output;

	public Context(String input) {
		this.input = input;
	}

	public String toString() {
		
		return input + " = " + output;
	}

}
