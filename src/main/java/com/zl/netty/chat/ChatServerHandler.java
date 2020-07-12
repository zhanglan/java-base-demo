package com.zl.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020-07-12 22:17
 */
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {
    private static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        group.writeAndFlush("客户端【" + channel.remoteAddress() + "】上线了");
        group.add(channel);
        System.out.println("客户端【" + channel.remoteAddress() + "】上线了");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        group.forEach(ch -> {
            if (channel.remoteAddress().equals(ch.remoteAddress())) {
                ch.writeAndFlush("【自己】说：" + msg);
            } else {
                ch.writeAndFlush("【" + channel.remoteAddress() + "】说：" + msg);
            }
        });
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        group.remove(channel);
        group.writeAndFlush("客户端【" + channel.remoteAddress() + "】下线了");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
