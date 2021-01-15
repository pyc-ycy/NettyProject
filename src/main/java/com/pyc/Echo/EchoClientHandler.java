package com.pyc.Echo;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author 御承扬
 * @product IntelliJ IDEA
 * @project NettyProject
 * @file EchoClientHandler
 * @pack com.pyc.Echo
 * @date 2021/1/15
 * @time 10:37
 * @E-mail 2923616405@qq.com
 **/


public class EchoClientHandler extends ChannelHandlerAdapter {
    private int counter = 0;
    static final  String ECHO_REQ = "Hi, PengYouCong. Welcome to Netty.$_";

    public EchoClientHandler(){}

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for(int i = 0; i < 10; i++){
            ctx.writeAndFlush(Unpooled.copiedBuffer(ECHO_REQ.getBytes()));
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("This is " + ++counter + "times receive server : [" + msg + "]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
