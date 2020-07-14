package com.zl.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/14
 */
public class Long2ByteEncoder extends MessageToByteEncoder {
	@Override
	protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
		System.out.println("Long2ByteEncoder encode...");
		if (o instanceof Long) {
			byteBuf.writeLong((Long) o);
		}
	}
}
