package com.zl.netty.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020-07-12 22:32
 */
public class ChatClient {
    private String host;

    private int port;

    private EventLoopGroup group;

    private Bootstrap bootstrap;

    public void initClient(String host, int port) {
        this.host = host;
        this.port = port;
        group = new NioEventLoopGroup();
        try {
            bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("decoder", new StringDecoder());
                            pipeline.addLast("encoder", new StringEncoder());
                            pipeline.addLast(new ChatClientHandler());
                        }
                    });
            ChannelFuture future = bootstrap.connect(this.host, this.port).sync();
            Channel channel = future.channel();
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String msg = scanner.nextLine();
                channel.writeAndFlush(msg);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient();
        client.initClient("127.0.0.1", 9000);
    }
}
