package com.pyc.tcp_sticky_packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.nio.charset.StandardCharsets;

/**
 * @author 御承扬
 * @product IntelliJ IDEA
 * @project NettyProject
 * @file TimeServerHandler
 * @pack com.pyc.tcp_sticky_packet
 * @date 2021/1/15
 * @time 8:53
 * @E-mail 2923616405@qq.com
 **/


public class TimeServerHandler extends ChannelHandlerAdapter {
    private int counter;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        /*ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, StandardCharsets.UTF_8).substring(0, req.length
        - System.getProperty("line.separator").length());*/
        // 为解决 TCP 粘包问题，将上述代码注释
        String body = (String) msg;
        System.out.println("The time server receive order :" + body + "; the counter is :" + ++counter);
        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)?new java.util.Date(System.currentTimeMillis())
                .toString():"BAD ORDER";
        currentTime = currentTime + System.getProperty("line.separator");
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.writeAndFlush(resp);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
