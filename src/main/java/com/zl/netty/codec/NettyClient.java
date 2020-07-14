package com.zl.netty.codec;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/14
 */
public class NettyClient {

	public void initClient(String ip, int port) throws InterruptedException {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(group)
					.channel(NioSocketChannel.class)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel socketChannel) throws Exception {
							ChannelPipeline pipeline = socketChannel.pipeline();
//							pipeline.addLast(new ObjectEncoder());
//							pipeline.addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
							pipeline.addLast(new Long2ByteEncoder());
							pipeline.addLast(new Byte2LongDecoder());
							pipeline.addLast(new NettyClientHandler());
						}
					});
			ChannelFuture future = bootstrap.connect(ip, port).sync();
			Channel channel = future.channel();
			for (int i = 0; i < 20; i++) {
//				channel.writeAndFlush(new Message(i, "你好" + i));
				channel.writeAndFlush((long)i);
			}
			channel.closeFuture().sync();
		} finally {
			group.shutdownGracefully();
		}
	}

	private class NettyClientHandler extends ChannelInboundHandlerAdapter {
		@Override
		public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//			Message message = (Message) msg;
//			System.out.println(message.toString());
			System.out.println(msg);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		NettyClient client = new NettyClient();
		client.initClient("127.0.0.1", 9000);
	}

}
