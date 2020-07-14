package com.zl.netty.split;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/14
 */
public class MessageEncoder extends MessageToByteEncoder<MessageProtocol> {
	@Override
	protected void encode(ChannelHandlerContext channelHandlerContext, MessageProtocol messageProtocol, ByteBuf byteBuf) throws Exception {
		byteBuf.writeInt(messageProtocol.getLength());
		byteBuf.writeBytes(messageProtocol.getContent());
	}
}
