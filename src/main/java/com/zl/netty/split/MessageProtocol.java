package com.zl.netty.split;

import lombok.Data;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/14
 */
@Data
public class MessageProtocol {

	private int length;

	private byte[] content;

}
