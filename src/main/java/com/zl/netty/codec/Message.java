package com.zl.netty.codec;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/14
 */
@Data
public class Message implements Serializable {

	private int id;

	private String msg;

	public Message(int id, String msg) {
		this.id = id;
		this.msg = msg;
	}

	public String toString() {
		return "{id: " + id + ", msg:" + msg + "}";
	}

}
