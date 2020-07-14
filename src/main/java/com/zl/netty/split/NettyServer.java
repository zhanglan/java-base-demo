package com.zl.netty.split;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/14
 */
public class NettyServer {

	public void initServer(int port) throws InterruptedException {
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.option(ChannelOption.SO_BACKLOG, 1024)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel socketChannel) throws Exception {
							ChannelPipeline pipeline = socketChannel.pipeline();

//							pipeline.addLast(new StringEncoder());
//							pipeline.addLast(new StringDecoder());
//							pipeline.addLast(new NettyServerHandler());

							pipeline.addLast(new MessageEncoder());
							pipeline.addLast(new MessageDecoder());
							pipeline.addLast(new SplitServerHandler());
						}
					});
			ChannelFuture future = bootstrap.bind(port).sync();
			future.channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	private class NettyServerHandler extends SimpleChannelInboundHandler<String> {

		@Override
		protected void channelRead0(ChannelHandlerContext channelHandlerContext, String msg) throws Exception {
			System.out.println(msg);
		}

	}

	private class SplitServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {

		@Override
		protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageProtocol messageProtocol) throws Exception {
			System.out.println("数据大小：" + messageProtocol.getLength());
			System.out.println("数据内容：" + new String(messageProtocol.getContent(), CharsetUtil.UTF_8));
		}

	}

	public static void main(String[] args) throws InterruptedException {
		NettyServer server = new NettyServer();
		server.initServer(9000);
	}

}
