package com.zl.netty.split;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/14
 */
public class MessageDecoder extends ByteToMessageDecoder {
	@Override
	protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
		if (byteBuf.readableBytes() >= 4) {
			int length = byteBuf.readInt();
			byte[] content = new byte[length];
			byteBuf.readBytes(content);

			MessageProtocol protocol = new MessageProtocol();
			protocol.setLength(length);
			protocol.setContent(content);

			list.add(protocol);
		}
	}
}
