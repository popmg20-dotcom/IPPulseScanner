package io.netty.channel;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface ChannelInboundHandler extends ChannelHandler {
    void channelActive(ChannelHandlerContext channelHandlerContext);

    void channelInactive(ChannelHandlerContext channelHandlerContext);

    void channelRead(ChannelHandlerContext channelHandlerContext, Object obj);

    void channelReadComplete(ChannelHandlerContext channelHandlerContext);

    void channelRegistered(ChannelHandlerContext channelHandlerContext);

    void channelUnregistered(ChannelHandlerContext channelHandlerContext);

    void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext);

    void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th);

    void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj);
}
