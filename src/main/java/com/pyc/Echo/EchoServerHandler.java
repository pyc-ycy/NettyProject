package com.pyc.Echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author 御承扬
 * @product IntelliJ IDEA
 * @project NettyProject
 * @file EchoServerHandler
 * @pack com.pyc.Echo
 * @date 2021/1/15
 * @time 10:19
 * @E-mail 2923616405@qq.com
 **/


public class EchoServerHandler extends ChannelHandlerAdapter {
    /*int counter = 0;*/
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        /*String body = (String) msg;
        System.out.println("This is" + ++counter + "times receive client :[" + body + "]");
        body += "$_";
        ByteBuf echo = Unpooled.copiedBuffer(body.getBytes());
        ctx.writeAndFlush(echo);*/
        // 由于使用了 FixedLengthFrameDecoder 解码器，代码改为：
        System.out.println("Received client : [" + msg + "]");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();    // 发生异常，关闭链路
    }
}
