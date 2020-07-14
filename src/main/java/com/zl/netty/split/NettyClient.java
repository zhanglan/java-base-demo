package com.zl.netty.split;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

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
//							pipeline.addLast(new StringEncoder());
//							pipeline.addLast(new StringDecoder());

							pipeline.addLast(new MessageEncoder());
							pipeline.addLast(new MessageDecoder());

						}
					});
			ChannelFuture future = bootstrap.connect(ip, port).sync();
			Channel channel = future.channel();
			String msg = "你好您好！";
			for (int i = 0; i < 20; i++) {
//				channel.writeAndFlush("你好！" + i);

				String str = msg + i;
				byte[] content = str.getBytes(CharsetUtil.UTF_8);
				MessageProtocol protocol = new MessageProtocol();
				protocol.setLength(content.length);
				protocol.setContent(content);
				channel.writeAndFlush(protocol);
			}
		} finally {
			group.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		NettyClient client = new NettyClient();
		client.initClient("127.0.0.1", 9000);
	}

}
