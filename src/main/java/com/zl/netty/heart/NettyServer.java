package com.zl.netty.heart;

import com.zl.netty.codec.Byte2LongDecoder;
import com.zl.netty.codec.Long2ByteEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

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
							pipeline.addLast(new StringEncoder());
							pipeline.addLast(new StringDecoder());
							pipeline.addLast(new IdleStateHandler(3, 0, 0, TimeUnit.SECONDS));
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

	private class NettyServerHandler extends SimpleChannelInboundHandler<String> {

		int idleTimes;

		@Override
		public void channelActive(ChannelHandlerContext ctx) throws Exception {
			Channel channel = ctx.channel();
			System.out.println("客户端【" + channel.remoteAddress() + "】上线了");
		}


		@Override
		protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
			System.out.println("客户端发来的消息：" + s);
			if ("heartbeat".equals(s)) {
				channelHandlerContext.channel().writeAndFlush("ok");
			}
		}

		@Override
		public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
			IdleStateEvent event = (IdleStateEvent) evt;
			String eventName = "";
			switch (event.state()) {
				case READER_IDLE:
					eventName = "读空闲";
					idleTimes++;
					break;
				case WRITER_IDLE:
					eventName = "写空闲";
					break;
				case ALL_IDLE:
					eventName = "全空闲";
					break;
			}

			System.out.println("超时时间：" + eventName);

			if (idleTimes > 3) {
				System.out.println("超时次数过多，关闭连接");
				ctx.channel().writeAndFlush("心跳超时，服务端断开连接");
				ctx.channel().close();
			}
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
