package com.zl.netty.codec;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

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
//							pipeline.addLast(new ObjectEncoder());
//							pipeline.addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
							pipeline.addLast(new Long2ByteEncoder());
							pipeline.addLast(new Byte2LongDecoder());
							pipeline.addLast(new NettyServerHandler());
						}
					});
			ChannelFuture future = bootstrap.bind(port).sync();
			future.channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}

	}

	private class NettyServerHandler extends ChannelInboundHandlerAdapter {

		@Override
		public void channelActive(ChannelHandlerContext ctx) throws Exception {
			Channel channel = ctx.channel();
			System.out.println("客户端【" + channel.remoteAddress() + "】上线了");
		}

		@Override
		public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
			Channel channel = ctx.channel();
//			Message message = (Message) msg;
//			System.out.println(message.toString());
//			channel.writeAndFlush(new Message(1001, "ok"));
			System.out.println(msg);
			channel.writeAndFlush(2000l);
		}

		@Override
		public void channelInactive(ChannelHandlerContext ctx) throws Exception {
			Channel channel = ctx.channel();
			System.out.println("客户端【" + channel.remoteAddress() + "】下线了");
		}

		@Override
		public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
			ctx.close();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		NettyServer server = new NettyServer();
		server.initServer(9000);
	}

}
