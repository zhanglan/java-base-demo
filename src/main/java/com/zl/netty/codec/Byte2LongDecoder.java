package com.zl.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/14
 */
public class Byte2LongDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
		System.out.println("Byte2LongDecoder decode...");
		if (byteBuf.readableBytes() >= 8) {
			list.add(byteBuf.readLong());
		}
	}

}
