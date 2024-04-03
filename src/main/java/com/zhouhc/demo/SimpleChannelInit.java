package com.zhouhc.demo;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class SimpleChannelInit extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 添加解码器，将接收到的ByteBuf转换为字符串
        pipeline.addLast(new StringDecoder());
        // 添加编码器，将写出的字符串转换为ByteBuf
        pipeline.addLast(new StringEncoder());
        // 添加自定义的处理器
        pipeline.addLast(new SimpleChannelInboundHandler());
    }
}
