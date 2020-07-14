package com.zl.netty.heart;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Random;

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
							pipeline.addLast(new StringEncoder());
							pipeline.addLast(new StringDecoder());
							pipeline.addLast(new NettyClientHandler());
						}
					});
			ChannelFuture future = bootstrap.connect(ip, port).sync();
			Channel channel = future.channel();
			String msg = "heartbeat";
			Random random = new Random();
			while (channel.isActive()) {
				int num = random.nextInt(6);
				Thread.sleep(num * 1000);
				channel.writeAndFlush(msg);
			}
		} finally {
			group.shutdownGracefully();
		}
	}

	private class NettyClientHandler extends SimpleChannelInboundHandler<String> {

		@Override
		protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
			System.out.println(s);
		}

	}

	public static void main(String[] args) throws InterruptedException {
		NettyClient client = new NettyClient();
		client.initClient("127.0.0.1", 9000);
	}

}
